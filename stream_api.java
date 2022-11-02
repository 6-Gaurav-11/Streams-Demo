package tests;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class stream_api {

	public static void main(String[] args) {
		
		Predicate<Integer> p1 = new Predicate<>() {
			public boolean test(Integer t) {
				if(t%2==0)
					return true;
				else
					return false;
			}
		};
		
		List<Integer> arr = new ArrayList<>(Arrays.asList(18,21,36,22,5,96,47,9,91,51,21));
		System.out.println(arr);
		
		List<Integer> arr2 = new ArrayList<>();
		for(int i: arr) {
			if(i%2==0)
				arr2.add(i);
		}
		System.out.println(arr2);
		
		Stream<Integer> s = arr.stream();
//		List<Integer> list = s.filter(i-> i%2==0).collect(Collectors.toList());
//		list.forEach(i-> System.out.print(i + " "));
		
		List<Integer> list2 = s.filter(i-> p1.test(i)).collect(Collectors.toList());  //filter
		System.out.println(list2);
		
		List<Integer> list3 = arr.stream().sorted().collect(Collectors.toList());   //sort
		System.out.println(list3);
		
		List<Integer> list4 = arr.stream().map(e-> e*e).collect(Collectors.toList());  //map
		System.out.println(list4);
		
		long a1 = arr.stream().count();                                               //count
		System.out.println(a1);
		
		List<Integer> list5 = arr.stream().distinct().collect(Collectors.toList());   //distinct
		System.out.println(list5);
		
		List<Integer> list6 = arr.stream().skip(2).limit(6).collect(Collectors.toList());     //skip & limit
		System.out.println(list6);
		
		Stream<Integer> s2 = Stream.iterate(1, i -> i+1).limit(50);                  //infinite stream                
			List<Integer> list7 = s2.collect(Collectors.toList());
			System.out.println(list7);
			
	}
}
