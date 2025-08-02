package com.modi.arxeta

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.ar.core.Config
import com.google.ar.core.Session
import com.google.ar.sceneform.ux.ArFragment

class CustomArFragment : ArFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        // Disable light estimation
        arSceneView?.post {
            val session: Session? = arSceneView?.session
            if (session != null) {
                val config = Config(session).apply {
                    lightEstimationMode = Config.LightEstimationMode.DISABLED
                }
                session.configure(config)
                Log.d("CustomArFragment", "AR session configured with light estimation DISABLED.")
            } else {
                Log.e("CustomArFragment", "Session is null. Configuration failed.")
            }
        }


        return view
    }
}
