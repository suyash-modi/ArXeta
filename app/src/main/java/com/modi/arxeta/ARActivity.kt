package com.modi.arxeta

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.Color as SceneformColor
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ShapeFactory
import com.google.ar.sceneform.ux.ArFragment

class ARActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private var objectPlaced = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aractivity)
        Log.d("ARActivity", "onCreate called. Setting up AR fragment.")

        arFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as CustomArFragment
        Log.d("ARActivity", "CustomArFragment loaded successfully.")

        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            Log.d("ARActivity", "Plane tapped.")
            if (objectPlaced) {
                Log.d("ARActivity", "Object already placed. Ignoring tap.")
                return@setOnTapArPlaneListener
            }

            Log.d("ARActivity", "Creating cube material...")
            MaterialFactory.makeOpaqueWithColor(
                this,
                SceneformColor(Color.BLUE)
            ).thenAccept { material ->
                Log.d("ARActivity", "Material created. Creating cube...")

                val cube = ShapeFactory.makeCube(
                    Vector3(0.1f, 0.1f, 0.1f),
                    Vector3(0f, 0.05f, 0f),
                    material
                )

                Log.d("ARActivity", "Cube shape created.")

                val anchorNode = AnchorNode(hitResult.createAnchor()).apply {
                    setParent(arFragment.arSceneView.scene)
                    Log.d("ARActivity", "AnchorNode attached to scene.")
                }

                Node().apply {
                    renderable = cube
                    setParent(anchorNode)
                    Log.d("ARActivity", "Cube Node added to AnchorNode.")
                }

                objectPlaced = true
                Log.d("ARActivity", "Cube placed successfully. objectPlaced set to true.")
            }.exceptionally { throwable ->
                Log.e("ARActivity", "Error creating material: ${throwable.message}")
                null
            }
        }
    }
}
