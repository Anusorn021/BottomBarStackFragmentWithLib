package views

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nu_therabbit.bottombarproject.R
import common.AbstractFragment
import common.ArrayAdapterData
import home.DefaultOneFragment

open class RecyclerViewFragment : AbstractFragment(), ArrayAdapterData.OnItemsClicked {
    companion object {
        fun newInstance(): RecyclerViewFragment {
            val bundle = Bundle()
            val fragment = RecyclerViewFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var recycler: RecyclerView? = null
    private var adapter: ArrayAdapterData? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycle_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.recycle_view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ArrayAdapterData()
        recycler?.layoutManager = LinearLayoutManager(context)
        recycler?.adapter = adapter
        initData(20)
        adapter?.setOnItemsClickListener(this)
        retainInstance = true
    }

    private fun initData(size: Int) {
        for (i in 1..size) {
            adapter?.add(common.Data(i))
        }
    }

    override fun onItemsClicked() {
        start(DefaultOneFragment.newInstance())
    }
}