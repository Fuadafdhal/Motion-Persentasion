package com.afdhal_fa.motionpersentasion

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.afdhal_fa.motionpersentasion.base.BaseToolbarActivity
import com.afdhal_fa.motionpersentasion.databinding.ActivityMainBinding

class MainActivity : BaseToolbarActivity<MainVModel>() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
//        viewmodel.setText("Motion - MP")
//        viewmodel.text.observe(this, {
//            mBinding.title.text = it
//        })

        val adapter = MainAdapter()

        adapter.onItemClick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewmodel.getDataText()
        viewmodel.dataText.observe(this, {
            adapter.setItem(it)
        })

        with(mBinding.rvText) {
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }

    override fun initViewModel() = ViewModelProvider(this)[MainVModel::class.java]

    override fun onShowProgressBar() {
        super.onShowProgressBar()
        // Todo Implement Progresbar
    }

    override fun onHideProgressBar() {
        super.onHideProgressBar()
        // Todo Implement Progresbar
    }

    override fun setToolbar(): Toolbar {
        return mBinding.container.toolbar
    }

    override fun setToolbarTitle(): Boolean {
        mBinding.container.textTitleToolbar.text = "Main"
        return super.setToolbarTitle()
    }
}