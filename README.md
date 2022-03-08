# Creating a java library, a place where any problem can be resolved.

Starting with the next class, called SummerDelivery, a delivery service planned to refresh a hot summer day...

```java
public class SummerDelivery {
	
	public static void main(String[] args) {
		for (String order: args) {
			switch(order) {
				case "PEACH_TENTATION":
					System.out.println("Peach Tentation Order...");
					//Anyone knows how to prepared it?
					break;
				case "FROZEN_APPLE":
					System.out.println("Frozen Apple Order...");
					//Anyone knows how to prepared it?
					break;
				default:
					System.out.println("Unexpected Order...");
					break;
			}
		}	
	}
}
```

But if we running the command to order a PEACH_TENTATION or a FROZEN_APPLE:

```bash
➜ java .\SummerDelivery.java PEACH_TENTATION FROZEN_APPLE
Peach Tentation Order...
Frozen Apple Order...
```

The program doesn’t know how to prepare one of its offered beverages, it needs a source with beverages preparation knowledge.

So, having the source below, capable of resolving SummerDelivered needs, called TropicalJuice:

```java
public class TropicalJuice {

	class Storage {
		public static final String PEACH_JUICE = "Peach juice";
		public static final String APPLE_JUICE = "Apple juice";
		public static final String LIMON_JUICE = "Limon juice";		
	}

	class Fridge {
		public static final String ICE_CUBES = "Ice cubes";
		public static final String CHERRY = "Cherry";
		public static final String LIMON_SHOT = "Limon shot";		
	}

	public class JuiceMan {
		public void preparePeachTentation() {
			System.out.println(String.format("Mixing a 250ml of %s with a %s and a few crushed %s.", 
				Storage.PEACH_JUICE, Fridge.LIMON_SHOT, Fridge.ICE_CUBES));
		}

		public void prepareFrozzenApple() {
			System.out.println(String.format("Mixing a 250ml of %s with 2 parts of crushed %s adding 100ml of %s.", 
				Storage.APPLE_JUICE, Fridge.ICE_CUBES, Storage.LIMON_JUICE));
		}
	}
}
```

It's necessary to include it inside SummerDelivery class to attend juice orders.

First of all, we compile TropicalJuice to a class file, executing the command below:

```bash
➜ javac -d . .\TropicalJuice.java
#it generates TropicalJuice.class,TropicalJuice$Fridge.class,TropicalJuice$JuiceMan.class,TropicalJuice$Storage.class
```

After, we package their .class files generated in a storage called tropical.jar, our java library, running the command below:

```bash
➜ jar --create --file tropical.jar .\TropicalJuice.class '.\TropicalJuice$Fridge.class' '.\TropicalJuice$JuiceMan.class' '.\TropicalJuice$Storage.class'
#it generates a jar called tropical.jar
```

With the created tropical.jar, we add to SummerDeliver class the library new methods.

```java
public class SummerDelivery {
	private static TropicalJuice tropicalJuice = new TropicalJuice();
	private static TropicalJuice.JuiceMan juiceMan = tropicalJuice.new JuiceMan();

	public static void main(String[] args) {
		for (String order: args) {
			switch(order) {
				case "PEACH_TENTATION":
					System.out.println("Peach Tentation Order...");
					juiceMan.preparePeachTentation();
					break;
				case "FROZZEN_APPLE":
					System.out.println("Frozen Apple Order...");
					juiceMan.prepareFrozzenApple();
					break;
				default:
					System.out.println("Unexpected Order...");
					break;
			}
		}	
	}
}
```

Adding the library in the first executed command:

```bash
➜ java -cp .\tropical.jar .\SummerDelivery.java FROZZEN_APPLE PEACH_TENTATION WATER
Frozen Apple Order...
Mixing a 250ml of Apple juice with 2 parts of crushed Ice cubes adding 100ml of Limon juice.
Peach Tentation Order...
Mixing a 250ml of Peach juice with a Limon shot and a few crushed Ice cubes.
Unexpected Order...
```

Yep! Now SummerDelivery knows how to refresh this summer! But it still doesn’t know how to serve a Water glass. If you know how to resolve it, please feel free to add it and test it to practice.

**That’s all!**

1. A problem happened.
2. We create a solution to solve it.
3. Package the solution as a library.
4. Add it and test it.
5. Problem fixed.

 **Command and options dictionary:**

- `java` run .class and .java files.
- `javac`compile .java files and creates .class files.
- `-d`indicate output folder.
- `-cp`indicate compiled folders directory(classpath).
- `jar` to execute actions related to java libraries.
- `—create` indicate jar action command.
- `—file` indicates a name file.

### Tech stack

- Java 11.
- Windows 10.
