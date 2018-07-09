package home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.nu_therabbit.bottombarproject.R
import common.AbstractFragment

class DefaultThreeFragment : AbstractFragment() {
    companion object {
        fun newInstance(): DefaultThreeFragment {
            val bundle = Bundle()
            val fragment = DefaultThreeFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var button: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.btn_recycle)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button?.setOnClickListener(View.OnClickListener {
            start(views.RecyclerViewFragment.newInstance())
        })
    }

}