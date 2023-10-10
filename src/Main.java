import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<Playground> vPlayground = new Vector<>();
	
	int scanInt() {
		int input;
		try {
			input = scan.nextInt();
		} catch (Exception e) {
			input = Integer.MIN_VALUE;
		}
		scan.nextLine();
		return input;
	}

	public Main() {
		int choose = -1;
		do {
			System.out.println("ToFun");
			System.out.println("=====");
			System.out.println("1. Add Playground");
			System.out.println("2. View Playground");
			System.out.println("3. Remove Playground");
			System.out.println("4. Exit");
			System.out.print(">>");
			choose = scanInt();
			
			switch (choose) {
			case 1:
				addPg();
				break;
			case 2:
				viewPg();
				break;
			case 3:
				removePg();
				break;
			case 4:
				System.out.println("Thank You!");
				break;
			}
			
		} while (choose != 4);
	}
	
	public void addPg() {
		String name ="";
		String type ="";
		int price =-1;
		
		do {
			System.out.print("Input playground name [5-20 characters]: ");
			name = scan.nextLine();
		} while (name.length()<5 || name.length()>20);
		
		do {
			System.out.print("Input playground type [Children|Adult][case sensitive]: ");
			type = scan.nextLine();
		} while (!type.equals("Children") && !type.equals("Adult"));
		
		if (type.equals("Children")) {
			do {
				System.out.print("Input playground price [15000-50000]: ");
				price = scanInt();
			} while (price<15000 || price>50000);
		}else if (type.equals("Adult")) {
			do {
				System.out.print("Input playground price [75000-250000]: ");
				price = scanInt();
			} while (price<75000 || price>250000);
		}
		System.out.println("Playground has been added!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
		Playground ins = new Playground();
		ins.setName(name);
		ins.setType(type);
		ins.setPrice(price);
		vPlayground.add(ins);
	}
	
	public void viewPg() {
			if (vPlayground.isEmpty()) {
				System.out.println("There is no playground!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
			}else {
				for (int i = 0; i < vPlayground.size()-1; i++) {
					for (int j = 0; j < vPlayground.size()-i-1; j++) {
						if (vPlayground.get(j).getName().charAt(0) > vPlayground.get(j+1).getName().charAt(0)) {
							Playground temp = vPlayground.get(j);
							vPlayground.set(j, vPlayground.get(j+1));
							vPlayground.set(j+1, temp);
						}
					}
				}
			}
			System.out.println("================================================================");
			System.out.println("|No.| ID      | Name                 | Type      | Price       |");
			System.out.println("================================================================");
			for (int i = 0; i < vPlayground.size(); i++) {
				String id = "";
				char randomChar1 = (char) ('A' + rand.nextInt(26));
				char randomChar2 = (char) ('A' + rand.nextInt(26));
				int randomNumber1 = rand.nextInt(10);
				int randomNumber2 = rand.nextInt(10);
				int randomNumber3 = rand.nextInt(10);
				
				id += (randomChar1 + "");
				id += (randomChar2 + "");
				id += (randomNumber1 + "");
				id += (randomNumber2 + "");
				id += (randomNumber3 + "");
				System.out.printf("|%2d | %-7s | %-20s | %-9s | Rp %-8d | \n", i+1, id, vPlayground.get(i).getName(), vPlayground.get(i).getType(), vPlayground.get(i).getPrice());
			}
			System.out.println("================================================================");
			System.out.println();
		} 

	public void removePg() {
		if (vPlayground.isEmpty()) {
			System.out.println("There is no playground!");
		}else {
			Integer del = -1;
			do {
				System.out.print("Choose playground to be removed [1-" + vPlayground.size() + "]: ");
				del = scanInt();
			} while (del<1 || del > vPlayground.size());
			vPlayground.remove(del-1);
			System.out.println("Playground has been removed!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}
