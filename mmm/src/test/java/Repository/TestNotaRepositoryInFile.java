package Repository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Domain.Student;
import Domain.Tema;
import ValidatorsAndExceptions.ValidatorStudent;
import org.junit.Test;

import Domain.Nota;
import Repository.NotaRepositoryInFile;
import ValidatorsAndExceptions.ValidatorNota;
import javafx.util.Pair;

public class TestNotaRepositoryInFile extends TestRepositoryInFile{

	NotaRepositoryInFile el;


	@Override
	public void testUpdate() {

	}

	@Override
	public AbstractRepository fill() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\CatalogTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ValidatorNota validatorNota = new ValidatorNota();
		NotaRepositoryInFile noteRepo = new NotaRepositoryInFile("src\\test\\java\\testResources\\CatalogTest.txt",
				validatorNota);
		Student a = new Student(1,"Robert",1,"robert@yahoo","Andrei");
		Tema t = new Tema(1,"tema1",3);
		Nota nota = new Nota(a,t,1,10);
		noteRepo.add(nota);
		toFindFirst=nota;
		noteRepo.createInstance("2|2|3|3");
		noteRepo.createInstance("3|3|3|3");
		size = 3;
		Student aa = new Student(4,"Sava",1,"sava@yahoo","Troanca");
		Tema tt = new Tema(4,"tema3",3);
		toAdd = new Nota(aa,tt,10,8);
		elem = noteRepo;
		elemTata = noteRepo;
		return noteRepo;
	}

	@Test
	public void testDelete(){}

	@Test
	public void testFindOne(){}

	@Test
	public void testAddError(){}

	/*@Test
	public void testCreateInstance() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("src\\test\\java\\testResources\\CatalogTest.txt");
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ValidatorNota validatorNota = new ValidatorNota();
		NotaRepositoryInFile notaRepo = new NotaRepositoryInFile("src\\test\\java\\testResources\\CatalogTest.txt",
				validatorNota);

		notaRepo.createInstance("2|1|10|3");

		List<Nota> note = new ArrayList<Nota>();

		notaRepo.getAll().forEach(nota -> {
			note.add(nota);
		});
		//assertEquals((long)10,(long) note.get(0).getValoare());
		assertEquals(new Pair<Integer,Integer>(2, 1), note.get(0).getID());
	}*/



}
