package mynewSeliniumProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Streamm {

	public static void main(String[] args) {
		System.out.println("Run this class as TestNG Test to see all outputs!");
    
	
		// TODO Auto-generated method stub
		//@Test
//		public void firstthing() {
		
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("Jecintha");
//		names.add("Jerlin");
//		names.add("Jackulin");
//		names.add("Jeni");
//		names.add("Joan");
//		names.add("Zarah");
//		
//		long c = names.stream().filter(s-> s.startsWith("J")).count();
//		System.out.println(c);
//		//names.stream().filter(s->s.length()==4).forEach(s->System.out.println(s));
//		names.stream().filter(s->s.length()==4).limit(1).forEach(s->System.out.println(s));
//	}

//	@Test
//
//		public void newexcersiseone() {
//
//	
//		Stream.of("Jecintha","Jerlin","Jackulin", "Jeni", "Joan" , "Zarah")
//		.filter(s->s.contains("J")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
//	}
//	
//	@Test
//	
//	
//	public void newexcersise() {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,6,5,8);
		List<Integer> li = values.stream().distinct().collect(Collectors.toList());
		System.out.println(li.get(2));
	}

	
}


