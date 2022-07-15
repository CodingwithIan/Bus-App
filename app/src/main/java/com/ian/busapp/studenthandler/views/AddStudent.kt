package com.ian.busapp.studenthandler.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.ian.busapp.R
import com.ian.busapp.studenthandler.HomeStudent
import com.ian.busapp.studenthandler.Students
import kotlinx.android.synthetic.main.activity_add_student.*

class AddStudent : AppCompatActivity() {
    private var mImageUri : Uri? = null
    private var mStorageRef:StorageReference? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var mUploadTask: StorageTask<*>? = null
    private val PICK_IMAGE_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        mStorageRef = FirebaseStorage.getInstance().getReference("teachers_uploads")
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teachers_uploads")

        button_choose_image.setOnClickListener { openFileChoose() }
        upLoadBtn.setOnClickListener {
            if (mUploadTask != null && mUploadTask!!.isInProgress){
                Toast.makeText(this@AddStudent,
                    "An Upload is Still in Progress",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                uploadFile()
            }
        }



    }
    private fun openFileChoose() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            mImageUri = data.data
            chooseImageView.setImageURI(mImageUri)
        }
    }
    private fun getFileExtension(uri: Uri): String? {
        val cR = contentResolver
        val mime = MimeTypeMap.getSingleton()
        return mime.getExtensionFromMimeType(cR.getType(uri))
    }

    private fun uploadFile() {
        if (mImageUri != null) {
            val fileReference = mStorageRef!!.child(
                System.currentTimeMillis()
                    .toString() + "." + getFileExtension(mImageUri!!)
            )
            progressBar.visibility = View.VISIBLE
            progressBar.isIndeterminate = true
            mUploadTask = fileReference.putFile(mImageUri!!)
                .addOnSuccessListener { taskSnapshot ->
                    val handler = Handler()
                    handler.postDelayed({
                        progressBar.visibility = View.VISIBLE
                        progressBar.isIndeterminate = false
                        progressBar.progress = 0
                    }, 500)
                    Toast.makeText(
                        this@AddStudent,
                        "Student data Upload successful",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    val upload = Students(
                        name = studentNameEt!!.text.toString().trim { it <= ' ' },
                        clas = studentClassEt!!.text.toString().trim { it <= ' ' },
                        station = stationEt!!.text.toString().trim { it <= ' ' },
                        mobile = guardianContactEt!!.text.toString().trim { it <= ' ' },
                        imageUrl = mImageUri.toString(),
                        school =  schoolNameEt!!.text.toString().trim { it <= ' ' }
                    )
                    val uploadId = mDatabaseRef!!.push().key
                    mDatabaseRef!!.child((uploadId)!!).setValue(upload)
                    progressBar.visibility = View.INVISIBLE
                    openImagesActivity()
                }
                .addOnFailureListener { e ->
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this@AddStudent, e.message, Toast.LENGTH_SHORT).show()
                    Log.e("data","${e.message}")
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress =
                        (100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount)
                    progressBar.progress = progress.toInt()
                }
        } else {
            Toast.makeText(this, "You haven't Selected Any file selected", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun  openImagesActivity() {
        startActivity(Intent(this@AddStudent, HomeStudent::class.java))
    }

}
