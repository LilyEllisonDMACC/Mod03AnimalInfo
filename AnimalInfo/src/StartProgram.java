

import java.util.List;
import java.util.Scanner;

import controller.ListAnimalHelper;
import model.AnimalList;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListAnimalHelper lah = new ListAnimalHelper();

		private static void addAnAnimal() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter a species: ");
			String species = in.nextLine();
			System.out.print("Enter a condition: ");
			String condition = in.nextLine();
			AnimalList toAdd = new AnimalList(name, species, condition);
			lah.insertAnimal(toAdd);

		}
		
		private static int selectSearchMethod() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Species");
			int searchBy = in.nextInt();
			in.nextLine();
			return searchBy;
		}

		private static void deleteAnAnimal() {
			// TODO Auto-generated method stub
			
			int wayToSearch = selectSearchMethod();
			List<AnimalList> deleteOptions = searchForAnimal(wayToSearch);
			AnimalList toDelete = pickOne(deleteOptions);
			if(toDelete == null) {
				runMenu();
			} else {
				if(confirmDelete(toDelete)) {
					lah.deleteAnimal(toDelete);
				} else {
					System.out.println("Results not confirmed. No action taken. Please try again.");
					runMenu();
				}
			}			

		}

		/**
		 * @param toDelete
		 * @return
		 */
		private static boolean confirmDelete(AnimalList toDelete) {
			// TODO Auto-generated method stub
			
			System.out.println("Please confirm this is the animal you would like to delete: ");
			System.out.println(toDelete.getId() + " : " + toDelete.getName() + ", a " + toDelete.getSpecies());
			System.out.println("1: Yes");
			System.out.println("2: No");
			int confirmationInt = in.nextInt();
			if(confirmationInt == 1) {
				System.out.println("Deleting ID " + toDelete.getId() + " : " + toDelete.getName() + ", a " + toDelete.getSpecies());
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param deleteOptions
		 * @return
		 */
		private static AnimalList pickOne(List<AnimalList> deleteOptions) {
			// TODO Auto-generated method stub
			
			if(verifyAnimal(deleteOptions)) {
				System.out.println("Found Results.");
				for (AnimalList l : deleteOptions) {
					System.out.println(l.getId() + " : " + l.getName() + ", a " + l.getSpecies());
				}
				System.out.print("Which ID: ");
				int idToEdit = in.nextInt();
				AnimalList toEdit = lah.searchForAnimalById(idToEdit);
				return toEdit;
			} else {
				return null;
			}
			
		}

		/**
		 * @param deleteOptions
		 * @return
		 */
		private static boolean verifyAnimal(List<AnimalList> deleteOptions) {
			// TODO Auto-generated method stub
			if(!deleteOptions.isEmpty()) {
				return true;
			} else {
				System.out.println("---- No results found.");
				System.out.println("Please try again.");
				return false;
			}
		}

		/**
		 * @param wayToSearch
		 * @return
		 */
		private static List<AnimalList> searchForAnimal(int wayToSearch) {
			// TODO Auto-generated method stub
			List<AnimalList> foundAnimals;
			if (wayToSearch == 1) {
				System.out.print("Enter the animal's name: ");
				String animalName = in.nextLine();
				foundAnimals = lah.searchForAnimalByName(animalName);
				
			} else {
				System.out.print("Enter the species: ");
				String speciesName = in.nextLine();
				foundAnimals = lah.searchForAnimalBySpecies(speciesName);

			}
			return foundAnimals;
		}

		private static void editAnAnimal() {
			// TODO Auto-generated method stub
			
			int wayToSearch = selectSearchMethod();
			List<AnimalList> editOptions = searchForAnimal(wayToSearch);
			AnimalList toEdit = pickOne(editOptions);
			if(toEdit == null) {
				runMenu();
			} else {			
				System.out.println("Retrieved " + toEdit.getName() + ", a " + toEdit.getSpecies());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Species");
				System.out.println("3 : Update Condition");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New Species: ");
					String newSpecies = in.nextLine();
					toEdit.setSpecies(newSpecies);
				} else if (update == 3) {
					System.out.print("New Condition: ");
					String newCondition = in.nextLine();
					toEdit.setCondition(newCondition);
				}

				lah.updateAnimal(toEdit);
			}

		} 
			
			
			
			
			/**
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Species");
			int searchBy = in.nextInt();
			in.nextLine();
			List<AnimalList> foundAnimals;
			if (searchBy == 1) {
				System.out.print("Enter the animal's name: ");
				String animalName = in.nextLine();
				foundAnimals = lah.searchForAnimalByName(animalName);
				
			} else {
				System.out.print("Enter the species: ");
				String speciesName = in.nextLine();
				foundAnimals = lah.searchForAnimalBySpecies(speciesName);

			}

			if (!foundAnimals.isEmpty()) {
				System.out.println("Found Results.");
				for (AnimalList l : foundAnimals) {
					System.out.println(l.getId() + " : " + l.getName() + ", a " + l.getSpecies());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				AnimalList toEdit = lah.searchForAnimalById(idToEdit);
				*/
				

		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome animal list! ---");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add an animal");
				System.out.println("*  2 -- Edit an animal");
				System.out.println("*  3 -- Delete an animal");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnAnimal();
				} else if (selection == 2) {
					editAnAnimal();
				} else if (selection == 3) {
					deleteAnAnimal();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lah.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<AnimalList> allAnimals = lah.showAllAnimals();
			for(AnimalList singleAnimal : allAnimals) {
				System.out.println(singleAnimal.returnAnimalDetails());
			}
			

		}

	}