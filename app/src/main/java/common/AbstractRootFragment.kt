package common

import android.os.Bundle
import android.util.Log
import com.example.nu_therabbit.bottombarproject.R
import home.*
import me.yokeyword.fragmentation.SupportFragment


open class AbstractRootFragment : SupportFragment() {
    override fun onBackPressedSupport(): Boolean {
        if (childFragmentManager.backStackEntryCount > 1) {
            popChild()
        } else {
            _mActivity.finish()
        }
        return true
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        when {
            this is RootOneFragment -> {
                if (findChildFragment(DefaultOneFragment::class.java) == null) {
                    loadRootFragment(R.id.container_one_fragment, DefaultOneFragment.newInstance())
                }
            }
            this is RootTwoFragment -> {
                if (findChildFragment(DefaultTwoFragment::class.java) == null) {
                    loadRootFragment(R.id.container_two_fragment, DefaultTwoFragment.newInstance())
                }
            }
            this is RootThreeFragment -> {
                if (findChildFragment(DefaultThreeFragment::class.java) == null) {
                    loadRootFragment(R.id.container_three_fragment, DefaultThreeFragment.newInstance())
                }
            }
            this is RootFourFragment -> {
                if (findChildFragment(DefaultFourFragment::class.java) == null) {
                    loadRootFragment(R.id.container_four_fragment, DefaultFourFragment.newInstance())
                }
            }
            this is RootFiveFragment -> {
                if (findChildFragment(DefaultFiveFragment::class.java) == null) {
                    loadRootFragment(R.id.container_five_fragment, DefaultFiveFragment.newInstance())
                }
            }
        }

    }

}