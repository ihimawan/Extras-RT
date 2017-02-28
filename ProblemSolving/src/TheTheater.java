import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheTheater {

	public static void main(String[] args) throws FileNotFoundException {
		
		Theater theater = new Theater(new File("theaterLayout.txt"));
		theater.placePartiesIntoTheater(new File("customerList.txt"), new File("resultList.txt"));
		
	}

}

class Theater {

	List<Row> rows;

	Theater(File theaterLayout) throws FileNotFoundException {

		rows = new ArrayList<Row>();

		Scanner sc = new Scanner(theaterLayout);

		int rowNumber = 1;

		while (sc.hasNextLine()) {
			Row row = new Row(rowNumber); // create new row
			String[] sections = sc.nextLine().split(" ");

			// create sections
			int sectionNumber = 1;
			for (String s : sections) {
				row.addSection(new Section(Integer.parseInt(s), rowNumber, sectionNumber++));
			}

			rows.add(row);
			rowNumber++;
		}
	}

	void placePartiesIntoTheater(File customerList, File resultList) throws FileNotFoundException{
		
		Scanner sc = new Scanner(customerList);
		PrintStream ps = new PrintStream(resultList);
		
		while (sc.hasNextLine()){
			String name = sc.next();
			int numberOfPeople = sc.nextInt();
			
			ps.println(name + " - "+ placeParty(numberOfPeople));

		}

	}

	String placeParty(int numberOfPeople) {

		try {
			Pair<Integer, Integer> position = placePartyHelper(numberOfPeople);
			return "Row " + position.first + ", Section " + position.second;
		} catch (PartyOverflowException e) {
			return "Cannot fit party into theater";
		} catch (SectionSplitException e) {
			return "Call to split party.";
		}
	}

	Pair<Integer, Integer> placePartyHelper(int numberOfPeople) throws PartyOverflowException, SectionSplitException {

		int membersLeftIfSplit = numberOfPeople;

		for (Row r : rows) {
			for (Section s : r.sections) {

				// if the party fits the section
				if (numberOfPeople <= s.availableSeats) {

					// then place that party there.
					return s.place(numberOfPeople);

					// otherwise, consider the possibility of splitting the
					// party
				} else {
					membersLeftIfSplit -= s.availableSeats;

				}
			}
		}

		// for loop exits if there is no fitting sections found. Must
		// either split or there is no available spot.

		// if there no more members that needs seats
		if (membersLeftIfSplit <= 0) {

			// then party may split
			throw new SectionSplitException();

		} else {

			// otherwise, cannot fit into theater
			throw new PartyOverflowException();
		}

	}

	void printLayout() {
		for (Row r : rows) {
			for (Section s : r.sections) {
				System.out.println(s.availableSeats);
			}
		}
	}

}

class Row {

	List<Section> sections;
	int rowNumber;

	Row(int rowNumber) {
		sections = new ArrayList<Section>();
		this.rowNumber = rowNumber;
	}

	void addSection(Section section) {
		sections.add(section);
	}

}

class Section {

	int availableSeats;
	int rowNumber;
	int sectionNumber;

	Section(int availableSeats, int rowNumber, int sectionNumber) {
		this.availableSeats = availableSeats;
		this.rowNumber = rowNumber;
		this.sectionNumber = sectionNumber;
	}

	Pair<Integer, Integer> place(int howManyPeople) {
		this.availableSeats -= howManyPeople;
		return new Pair<Integer, Integer>(rowNumber, sectionNumber);
	}

}

class PartyOverflowException extends Exception {

}

class SectionSplitException extends Exception {

}

class Pair<L, R> {

	public L first;
	public R second;

	Pair(L first, R second) {
		super();
		this.first = first;
		this.second = second;
	}

}