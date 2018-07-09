package common;

public class BottomBarManager {
    private static BottomBarManager instance;

    public static BottomBarManager getInstance(){
        if (instance == null){
            instance = new BottomBarManager();
        }
        return instance;
    }

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
