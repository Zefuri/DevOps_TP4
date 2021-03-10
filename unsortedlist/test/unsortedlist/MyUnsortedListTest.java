package unsortedlist;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;
import datastruct.UnsortedList;

public class MyUnsortedListTest {

	@Test
	public void testOf() {
		assertNotNull(MyUnsortedList.of());
	}
	
	@Test
	public void testOfIterable() {
		Integer[] l = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		assertNotNull(MyUnsortedList.of(l));
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(MyUnsortedList.of().isEmpty());
	}
	
	@Test
	public void testSize() {
		UnsortedList<Integer> l1 = MyUnsortedList.of();
		UnsortedList<Integer> l2 = MyUnsortedList.of(1, 2, 3, 4, 5);
		
		Iterable<Integer> v3 = new ArrayList<Integer>();
		for(int i = 0; i < 50; i++) {
			((ArrayList<Integer>) v3).add(i);
		}
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		
		Iterable<Integer> v4 = new ArrayList<Integer>();
		for(int i = 0; i < 500; i++) {
			((ArrayList<Integer>) v4).add(i);
		}
		UnsortedList<Integer> l4 = MyUnsortedList.of(v4);
		
		Iterable<Integer> v5 = new ArrayList<Integer>();
		for(int i = 0; i < 5000; i++) {
			((ArrayList<Integer>) v5).add(i);
		}
		UnsortedList<Integer> l5 = MyUnsortedList.of(v5);
		
		Integer[] expected = {0, 5, 50, 500, 5000};
		
		Integer[] actual = {l1.size(), l2.size(), l3.size(), l4.size(), l5.size()};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testEqualsFalseInstance() {
		assertFalse(MyUnsortedList.of(0, 1, 2, 3).equals(Integer.valueOf(0)));
	}
	
	@Test
	public void testNotEquals() {
		assertNotEquals(MyUnsortedList.of(0, 1, 3), MyUnsortedList.of(0, 1, 2, 3));
	}
	
	@Test
	public void testEqualsEmptyList() {
		assertEquals(MyUnsortedList.of(0, 1, 3, 3), MyUnsortedList.of(0, 1, 2, 3));
	}
	
	@Test
	public void testEquals() {
		assertEquals(MyUnsortedList.of(0, 1, 2, 3), MyUnsortedList.of(0, 1, 2, 3));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBound() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.remove(0);
	}
	
	@Test
	public void testRemove() {
		Integer v1 = 0;
		UnsortedList<Integer> l1 = MyUnsortedList.of(v1);
		
		UnsortedList<Integer> expectedL1 = MyUnsortedList.of();
		
		Integer[] v2 = {0, 1, 2, 3};
		UnsortedList<Integer> l2 = MyUnsortedList.of(v2);
		
		Integer[] expectedV2 = {0, 2, 3};
		UnsortedList<Integer> expectedL2 = MyUnsortedList.of(expectedV2);
		
		Integer[] v3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10};
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		
		Integer[] expectedV3 = {0, 1, 2, 3, 4, 5, 6, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10};
		UnsortedList<Integer> expectedL3 = MyUnsortedList.of(expectedV3);
		
		ArrayList<UnsortedList<Integer>> expected = new ArrayList<>();
		expected.add(expectedL1);
		expected.add(expectedL2);
		expected.add(expectedL3);
		
		l1.remove(0);
		l2.remove(1);
		l3.remove(8);
		
		ArrayList<UnsortedList<Integer>> actual = new ArrayList<>();
		actual.add(l1);
		actual.add(l2);
		actual.add(l3);
		
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.pop();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPopLastEmptyList() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.popLast();
	}
	
	@Test
	public void testPop() {
		Integer v1 = 0;
		UnsortedList<Integer> l1 = MyUnsortedList.of(v1);
		
		Integer[] v2 = {0, 1, 2, 3};
		UnsortedList<Integer> l2 = MyUnsortedList.of(v2);
		
		Integer[] v3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10};
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		
		Integer[] expected = {0, 0, 0};
		
		Integer[] actual = {l1.pop(), l2.pop(), l3.pop()};
		
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testPopLast() {
		Integer v1 = 0;
		UnsortedList<Integer> l1 = MyUnsortedList.of(v1);
		
		Integer[] v2 = {0, 1, 2, 3};
		UnsortedList<Integer> l2 = MyUnsortedList.of(v2);
		
		Integer[] v3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10};
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		
		Integer[] expected = {0, 3, 10};
		
		Integer[] actual = {l1.popLast(), l2.popLast(), l3.popLast()};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testPrepend() {
		UnsortedList<Integer> l1 = MyUnsortedList.of();
		l1.prepend(0);
		
		Integer[] v2 = {1, 2, 3};
		UnsortedList<Integer> l2 = MyUnsortedList.of(v2);
		l2.prepend(0);
		
		Integer[] v3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10};
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		l3.prepend(0);
		
		Integer[] expected = {0, 0, 0};
		
		Integer[] actual = {l1.pop(), l2.pop(), l3.pop()};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertOutOfBound() {
		UnsortedList<Integer> l = MyUnsortedList.of();
		l.insert(0, 1);
	}
	
	@Test
	public void testInsert() {
		UnsortedList<Integer> l1 = MyUnsortedList.of();
		l1.insert(0, 0);
		
		Integer[] v2 = {0, 1, 3};
		UnsortedList<Integer> l2 = MyUnsortedList.of(v2);
		l2.insert(2, 2);
		
		Integer[] v3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10};
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		l3.insert(12, 12);
		
		Integer[] expected = {0, 2, 12};
		
		Integer[] actual = {l1.remove(0), l2.remove(2), l3.remove(12)};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testAppend() {
		UnsortedList<Integer> l1 = MyUnsortedList.of();
		l1.append(0);
		
		Integer[] v2 = {0, 1, 2};
		UnsortedList<Integer> l2 = MyUnsortedList.of(v2);
		l2.append(3);
		
		Integer[] v3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
		UnsortedList<Integer> l3 = MyUnsortedList.of(v3);
		l3.append(10);
		
		Integer[] expected = {0, 3, 10};
		
		Integer[] actual = {l1.popLast(), l2.popLast(), l3.popLast()};
		
		assertArrayEquals(expected, actual);
	}
}
