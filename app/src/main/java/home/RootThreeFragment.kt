package home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nu_therabbit.bottombarproject.R
import common.AbstractRootFragment

class RootThreeFragment : AbstractRootFragment() {
    companion object {
        fun newInstance(): RootThreeFragment {
            val bundle = Bundle()
            val fragment = RootThreeFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_three_root, container, false)
    }

}