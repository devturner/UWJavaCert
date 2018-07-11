package edu.washington.ext;

public class BookApp {
	public static void main(String[] args) {

		/**
		 * This is setting the instance of my book object to run the app.
		 */

		Book x = new Book(null, null, null, null, 0, null);

		/**
		 * Here I am verifying the number of args that my program was passed, if
		 * there is only 1 arg provided, the app calls the
		 * getTotalWordsInDescription & getTotalUniqueWordsInDescription
		 * methods.
		 * 
		 * If 2 args are provided, the getTotalWordsInDescription &
		 * getTotalUniqueWordsInDescription & getTotalWordInDescription methods
		 * are called, further, and new book is then created and all the
		 * information is printed again.
		 * 
		 */
		if (args.length == 1) {
			int a = x.getTotalWordsInDescription(args[0]);
			int b = x.getTotalUniqueWordsInDescription(args[0]);
			System.out.println("Total words in the description is: " + a);
			System.out.println("The description has " + b + " unique words!");
			System.out
					.println("Further, you could've asearched for the number of times a word was used in the description");
		} else {

			int a = x.getTotalWordsInDescription(args[0]);
			int b = x.getTotalUniqueWordsInDescription(args[0]);
			int c = x.getTotalWordInDescription(args[1]);
			System.out
					.println("Total words in the description provided by the 1st arguement is: "
							+ a);
			System.out.println("The provided description has " + b
					+ " unique words!");
			System.out.println("The requested word " + "'" + args[1] + "'"
					+ " was used " + c + " times!");

			Book newBook = new Book("Cay Horstman", "Core Java Vol 1, 9th Ed",
					"Prentice Hall", Binding.PAPERBACK, 1008, args[0]);

			int totalWords = newBook.getTotalWordsInDescription(newBook
					.getDescription());
			int uniqueWords = newBook.getTotalUniqueWordsInDescription(newBook
					.getDescription());
			int requestedWord = newBook.getTotalWordInDescription(args[1]);

			newBook.printDetails();
			System.out.println();
			System.out.println("Total words in the description is: "
					+ totalWords);
			System.out.println("The description has " + uniqueWords
					+ " unique words!");
			System.out.println("The requested word " + "'" + args[1] + "'"
					+ " was used " + requestedWord + " times!");

		}

	}

}
