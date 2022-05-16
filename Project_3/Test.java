public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Create an instance of the class TreeMap, HashMapSC, and HashMapLP. The tree map should be created with an object of type StringComparator. The hash tables should be created with a capacity equal to 100,000



        TreeMap<StringComparator> tm = new TreeMap<StringComparator>();
        HashMapSC<String, String> hm = new HashMapSC<String, String>(100000);
        HashMapLP<String, String> hm2 = new HashMapLP<String, String>(100000);

        // Read the file users.txt and add the usernames and passwords to each data structure. Note that the username is used as the key in the tree map and the hash tables.


        try {
            Scanner sc = new Scanner(new File("users.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" ");
                String username = parts[0];
                String password = parts[1];
                tm.put(new StringComparator(username), password);
                hm.put(username, password);
                hm2.put(username, password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Search, in the three data structures, for the 100 random usernames stored in the file user_list.txt, and display the number of iterations it takes the method get() to find the username in each data structure (display the iterations for only 20 search operations out of the 100).. Have the methods get() set a static variable, iterations, to the number of iterations it takes the method to find or not to find the key.

        


        

    }

    
}
