package Java8_LambdaExpressions;

import java.util.function.Consumer;

public class Test {

	public static void main(String[] args) {
		Consumer<String> consumer1 = (String name) -> {System.out.println(name);};
		consumer1.accept("Abdul");
		
		
		Consumer<Integer> consumer2 = System.out::println;
		consumer2.accept(3);
		
		Consumer<Boolean> consumer3 = System.out::println;
		consumer3.accept(true);
	}
	

}
