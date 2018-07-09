package home;

import android.os.Bundle;

import com.example.nu_therabbit.bottombarproject.R;

import bottombar.BottomBar;
import bottombar.OnTabSelectListener;
import common.AbstractActivity;
import common.BottomBarManager;
import common.MainBus;
import event.TabSelected;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends AbstractActivity {

    private BottomBar bottomBar;
    private SupportFragment fragments[] = {RootOneFragment.Companion.newInstance(), RootTwoFragment.Companion.newInstance(), RootThreeFragment.Companion.newInstance(), RootFourFragment.Companion.newInstance(), RootFiveFragment.Companion.newInstance()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int preTabId,int tabId) {
                BottomBarManager.getInstance().setPage(bottomBar.findPositionForTabWithId(tabId));
                MainBus.getInstance().post(new TabSelected(bottomBar.findPositionForTabWithId(tabId)));
                showHideFragment(fragments[bottomBar.findPositionForTabWithId(tabId)]);
            }
        });

        initFragments();

        showHideFragment(fragments[0]);
        BottomBarManager.getInstance().setPage(0);

    }

    private void initFragments(){
        if (findFragment(RootOneFragment.class) == null){
            loadMultipleRootFragment(R.id.container_fragment_main,0,fragments[0],fragments[1],fragments[2],fragments[3],fragments[4]);
        }
        else{
            fragments[0] = findFragment(RootOneFragment.class);
            fragments[1] = findFragment(RootTwoFragment.class);
            fragments[2] = findFragment(RootThreeFragment.class);
            fragments[3] = findFragment(RootFourFragment.class);
            fragments[4] = findFragment(RootFiveFragment.class);
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

}
