import java.util.ArrayList;

public class CategoryManager {
    private ArrayList<Category> categories;

    public CategoryManager() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void add(Category category) {
        categories.add(category);
    }

    public boolean checkIfCategoryExists(String categoryName) {
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                return true;
            }
        }

        return false;
    }

    public void displayAllCategories() {
        if (!categories.isEmpty()) {
            for (Category category : categories) {
                System.out.println("Category: " + category.getName());
            }
        } else {
            System.out.println("There is no existing categories");
        }
    }
}
