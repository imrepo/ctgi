JVM (Java Virtual Machine)
========================

JVM (Java Virtual Machine) is an abstract machine. It is a specification that provides runtime environment in which java bytecode can be executed.

JVMs are available for many hardware and software platforms (i.e.JVM is plateform dependent).

####What is JVM?

It is:

* A specification where working of Java Virtual Machine is specified. But implementation provider is independent to choose the algorithm. Its implementation has been provided by Sun and other companies. Apple has its own JVM.You can find mac java [here](http://support.apple.com/kb/DL1572?viewlocale=en_US&locale=en_US)
* An implementation Its implementation is known as JRE (Java Runtime Environment).
* Runtime Instance Whenever you write java command on the command prompt to run the java class, and instance of JVM is created.




####What it does?

####The JVM performs following operation:

* Loads code
* Verifies code
* Executes code
* Provides runtime environment
* JVM provides definitions for the:

####Memory area
* Class file format
* Register set
* Garbage-collected heap
* Fatal error reporting etc.
* Internal Architecture of JVM

####The Architecture of the Java Virtual Machine

Let's understand the internal architecture of JVM. It contains classloader, memory area, execution engine etc.
Jvm Internal 


In the Java virtual machine specification, the behavior of a virtual machine instance is described in terms of subsystems, memory areas, data types, and instructions. These components describe an abstract inner architecture for the abstract Java virtual machine. The purpose of these components is not so much to dictate an inner architecture for implementations. It is more to provide a way to strictly define the external behavior of implementations. The specification defines the required behavior of any Java virtual machine implementation in terms of these abstract components and their interactions.

Figure 5-1 shows a block diagram of the Java virtual machine that includes the major subsystems and memory areas described in the specification. As mentioned in previous chapters, each Java virtual machine has a class loader subsystem: a mechanism for loading types (classes and interfaces) given fully qualified names. Each Java virtual machine also has an execution engine: a mechanism responsible for executing the instructions contained in the methods of loaded classes.

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/jvminternal.gif "JVM Internal")

When a Java virtual machine runs a program, it needs memory to store many things, including bytecodes and other information it extracts from loaded class files, objects the program instantiates, parameters to methods, return values, local variables, and intermediate results of computations. The Java virtual machine organizes the memory it needs to execute a program into several runtime data areas.

Although the same runtime data areas exist in some form in every Java virtual machine implementation, their specification is quite abstract. Many decisions about the structural details of the runtime data areas are left to the designers of individual implementations.

Different implementations of the virtual machine can have very different memory constraints. Some implementations may have a lot of memory in which to work, others may have very little. Some implementations may be able to take advantage of virtual memory, others may not. The abstract nature of the specification of the runtime data areas helps make it easier to implement the Java virtual machine on a wide variety of computers and devices.

Some runtime data areas are shared among all of an application's threads and others are unique to individual threads. Each instance of the Java virtual machine has one method area and one heap. These areas are shared by all threads running inside the virtual machine. When the virtual machine loads a class file, it parses information about a type from the binary data contained in the class file. It places this type information into the method area. As the program runs, the virtual machine places all objects the program instantiates onto the heap. See Figure 5-2 for a graphical depiction of these memory areas.

![ctgi](https://github.com/dineshappavoo/ctgi/blob/master/src/com/ctgi/images/jvmfig5-2.gif "JVM Internal classes")

***As each new thread comes into existence, it gets its own pc register (program counter) and Java stack***. If the thread is executing a Java method (not a native method), the value of the pc register indicates the next instruction to execute. A thread's Java stack stores the state of Java (not native) method invocations for the thread. The state of a Java method invocation includes its local variables, the parameters with which it was invoked, its return value (if any), and intermediate calculations. The state of native method invocations is stored in an implementation-dependent way in native method stacks, as well as possibly in registers or other implementation-dependent memory areas.

The Java stack is composed of stack frames (or frames). A stack frame contains the state of one Java method invocation. When a thread invokes a method, the Java virtual machine pushes a new frame onto that thread's Java stack. When the method completes, the virtual machine pops and discards the frame for that method.

The Java virtual machine has no registers to hold intermediate data values. The instruction set uses the Java stack for storage of intermediate data values. This approach was taken by Java's designers to keep the Java virtual machine's instruction set compact and to facilitate implementation on architectures with few or irregular general purpose registers. In addition, the stack-based architecture of the Java virtual machine's instruction set facilitates the code optimization work done by just-in-time and dynamic compilers that operate at run-time in some virtual machine implementations.

See Figure 5-3 for a graphical depiction of the memory areas the Java virtual machine creates for each thread. These areas are private to the owning thread. ***No thread can access the pc register or Java stack of another thread***.



**1) Classloader:**

Classloader is a subsystem of JVM that is used to load class files.

**2) Class(Method) Area:**

Class(Method) Area stores per-class structures such as the runtime constant pool, field and method data, the code for methods.

**3) Heap:**

It is the runtime data area in which objects are allocated.

**4) Stack:**

Java Stack stores frames.It holds local variables and partial results, and plays a part in method invocation and return.
Each thread has a private JVM stack, created at the same time as thread.
A new frame is created each time a method is invoked. A frame is destroyed when its method invocation completes.
5) Program Counter Register:

PC (program counter) register. It contains the address of the Java virtual machine instruction currently being executed.

**6) Native Method Stack:**

It contains all the native methods used in the application.

**7) Execution Engine:**

It contains:
1) A virtual processor
2) Interpreter:Read bytecode stream then execute the instructions.
3) Just-In-Time(JIT) compiler:It is used to improve the performance.JIT compiles parts of the byte code that have similar functionality at the same time, and hence reduces the amount of time needed for compilation.Here the term ?compiler? refers to a translator from the instruction set of a Java virtual machine (JVM) to the instruction set of a specific CPU.

###Referrences

* [toptal.com](http://www.toptal.com/java/)
