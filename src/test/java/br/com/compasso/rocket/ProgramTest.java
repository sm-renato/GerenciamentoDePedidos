package br.com.compasso.rocket;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ProgramTest {

	@Test
	public void test() {
		try {
			assertTrue(new File("pom.xml").exists());
			throw new RuntimeException();
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
}
