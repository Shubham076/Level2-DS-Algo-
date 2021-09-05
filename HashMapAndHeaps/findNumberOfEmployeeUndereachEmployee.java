import java.util.*;
class findNumberOfEmployeeUndereachEmployee {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String , String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String employee = scn.next();
			String manager = scn.next();
			map.put(employee , manager);

		}
		printEmployeeCount(map);
	}

	public static void printEmployeeCount(HashMap<String , String> m) {
		HashMap<String, HashSet<String>> map = new HashMap<>();
		String ceo = "";
		for (String employee : m.keySet()) {
			String manager = m.get(employee);
			if (manager.equals(employee)) {
				ceo = manager;
			} 
			else if (map.containsKey(manager)) {
				HashSet<String> employees = map.get(manager);
				employees.add(employee);
			} else {
				HashSet<String> employees = new HashSet<>();
				employees.add(employee);
				map.put(manager , employees);
			}
		}

		HashMap<String , Integer> res = new HashMap<>();
		printTree(ceo , map , res);
		System.out.println(res);
	}

	public static int printTree(String manager, HashMap<String , HashSet<String>> tree,  HashMap<String , Integer> res) {
		if (!tree.containsKey(manager)) {
			res.put(manager , 0);
			return 1;
		}
		int size = 0;
		for (String emp : tree.get(manager)) {
			size += printTree(emp , tree , res);
		}
		res.put(manager , size);
		return size + 1;
	}
}