class Badge {
    public String print(Integer id, String name, String department) {
        
 // Check if the department is null, if so set it to "OWNER"
        if (department == null) {
            department = "OWNER";
        } else {
            // Otherwise, convert the department to uppercase
            department = department.toUpperCase();
        }

        // If the ID is not null, print the ID, else print just the name and department
        if (id != null) {
            return "[" + id + "] - " + name + " - " + department;
        } 
            return name + " - " + department;
        
    }
}
