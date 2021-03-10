package unsortedlist;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

public class MyUnsortedListTest {
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEmpty() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		assertTrue("Test si la list est vide",integers.isEmpty());
		
		MyUnsortedList<Integer> integers2 = MyUnsortedList.of(1);
		assertFalse("Test si la list n'est pas vide",integers2.isEmpty());
	}
	
	@Test
	public void testSize() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		assertEquals("Test pour la taille null",integers.size(), 0);
		
		MyUnsortedList<Character> integers2 = MyUnsortedList.of('1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1');
		assertEquals("Test pour une grande taille ",integers2.size(), 21);
	}
	
	@Test
	public void testPrepend() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		MyUnsortedList<Integer> integers2 = MyUnsortedList.of(3);
		MyUnsortedList<Integer> integers3 = MyUnsortedList.of(4,3);
		MyUnsortedList<Integer> integers4 = MyUnsortedList.of(5,4,3);
		integers.prepend(3);
		assertEquals("Ajout en debut d'une list vide",integers, integers2);
		integers.prepend(4);
		assertEquals("Ajout en debut d'une list avec une valeur",integers, integers3);
		integers.prepend(5);
		assertEquals("Ajout en debut d'une list avec le nombre de valeurs quelconque",integers, integers4);
	}
	
	@Test
	public void testAppend() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		MyUnsortedList<Integer> integers2 = MyUnsortedList.of(3);
		MyUnsortedList<Integer> integers3 = MyUnsortedList.of(3,4);
		MyUnsortedList<Integer> integers4 = MyUnsortedList.of(3,4,5);
		integers.append(3);
		assertEquals("Ajout a la fin d'une list vide",integers, integers2);
		integers.append(4);
		assertEquals("Ajout a la fin d'une list avec une valeur",integers, integers3);
		integers.append(5);
		assertEquals("Ajout a la fin d'une list avec le nombre de valeurs quelconque",integers, integers4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testBadIndexInsertion() throws Exception{
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		integers.insert(4,666); // should fail with IndexOutOfBoundsException exception
	}
	
	@Test
	public void testInsertion() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		MyUnsortedList<Integer> integers2 = MyUnsortedList.of(3);
		MyUnsortedList<Integer> integers3 = MyUnsortedList.of(5,3);
		MyUnsortedList<Integer> integers4 = MyUnsortedList.of(5,4,3);
		MyUnsortedList<Integer> integers5 = MyUnsortedList.of(5,4,3,2);
		integers.insert(3,0);
		assertEquals("Insertion dans une list vide",integers, integers2);
		integers.insert(5,0);
		assertEquals("Insertion en debut d'une list",integers, integers3);
		integers.insert(4,1);
		assertEquals("Insertion au milieu d'une list",integers, integers4);
		integers.insert(2, integers.size());
		assertEquals("Insertion a la fin d'une list",integers, integers5);
	}
	
	@Test(expected = EmptyListException.class)
	public void testEmptyListPop() throws Exception{
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		integers.pop(); // should fail with EmptyListException exception
	}
	
	@Test
	public void testPop() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of(3,4);
		int i;
		i=integers.pop();
		assertEquals("Enleve l'element sur la premier position d'une list avec >1 valeurs",i,3);
		i=integers.pop();
		assertEquals("Enleve l'element sur la premier position d'une list avec 1 valeur",i,4);
	} 	
	
	@Test(expected = EmptyListException.class)
	public void testEmptyListPopLast() throws Exception{
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		integers.popLast(); // should fail with EmptyListException exception
	}
	
	@Test
	public void testPopLast() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of(3,4);
		int i;
		i=integers.popLast();
		assertEquals("Enleve l'element sur la derniere position d'une list avec >1 valeurs",i,4);
		i=integers.popLast();
		assertEquals("Enleve l'element sur la derniere position d'une list avec 1 valeur",i,3);
	} 
	
	@Test
	public void testRemove() {
		MyUnsortedList<Integer> integers = MyUnsortedList.of(3,4,5);
		int i;
		i=integers.remove(2);
		assertEquals("Supprimer un element a la fin d'une list",i,5);
		i=integers.remove(0);
		assertEquals("Supprimer un element en debut d'une list",i,3);
		i=integers.remove(0);
		assertEquals("Enlever le seul element de la list",i,4);
	} 
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmptyListRemove() throws Exception{
		MyUnsortedList<Integer> integers = MyUnsortedList.of();
		integers.remove(0); // should fail with IndexOutOfBoundsException exception
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testBadIndexListRemove() throws Exception{
		MyUnsortedList<Integer> integers = MyUnsortedList.of(1,2);
		integers.remove(4); // should fail with IndexOutOfBoundsException exception
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testBadIndex2ListRemove() throws Exception{
		MyUnsortedList<Integer> integers = MyUnsortedList.of(1,2);
		integers.remove(-1); // should fail with IndexOutOfBoundsException exception
	}

}
