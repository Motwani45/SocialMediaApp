package com.example.socialmediaapp.fragments;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.socialmediaapp.R;
import com.example.socialmediaapp.adapters.FriendsLayoutAdapter;
import com.example.socialmediaapp.databinding.FragmentProfileBinding;
import com.example.socialmediaapp.models.FriendsLayoutModel;
import com.google.firebase.storage.FirebaseStorage;

import java.io.File;
import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    ArrayList<FriendsLayoutModel> friendsLayoutModelArrayList;
    FirebaseStorage storage;
    Uri cameraUri;
    File image;
    ActivityResultLauncher<Uri> activityResultLauncherBackgroundImageCamera, activityResultLauncherProfileImageCamera;
    ActivityResultLauncher<Intent> activityResultLauncherBackgroundImage;
    ActivityResultLauncher<Intent> activityResultLauncherProfileImage;
    ActivityResultLauncher<String> getActivityResultLauncherCameraRequestProfile, getActivityResultLauncherCameraRequestBackground, getActivityResultLauncherStorageRequestProfile, getActivityResultLauncherStorageRequestBackground;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = new File(getContext().getFilesDir(), "camera_photo.png");
        cameraUri = FileProvider.getUriForFile(getContext(), "com.example.socialmediaapp.provider", image);
        activityResultLauncherBackgroundImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getData() != null) {
                    Uri uri = result.getData().getData();
                    binding.backgroundimageview.setImageURI(uri);
                }
            }
        });
        activityResultLauncherBackgroundImageCamera = registerForActivityResult(new ActivityResultContracts.TakePicture(), new
                ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean result) {
                        if (result) {
                            binding.backgroundimageview.setImageURI(null);
                            binding.backgroundimageview.setImageURI(cameraUri);
                        }
                    }
                });
        activityResultLauncherProfileImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getData() != null) {
                    Uri uri = result.getData().getData();
                    binding.profileimageview.setImageURI(uri);
                }

            }
        });
        activityResultLauncherProfileImageCamera = registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    binding.profileimageview.setImageURI(null);
                    binding.profileimageview.setImageURI(cameraUri);
                }
            }
        });
        getActivityResultLauncherCameraRequestProfile = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    pickFromCamera(2);
                } else {
                    return;
                }
            }
        });
        getActivityResultLauncherCameraRequestBackground = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    pickFromCamera(1);
                } else {
                    return;
                }
            }
        });
        getActivityResultLauncherStorageRequestProfile = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    pickFromStorage(2);
                } else {
                    return;
                }
            }
        });
        getActivityResultLauncherStorageRequestBackground = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    pickFromStorage(1);
                } else {
                    return;
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setFriendsRecyclerView();
        binding.changeprofileimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImagePicDialogforProfile();
            }
        });
        binding.changebackgroundimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImagePicDialogforBackground();
            }
        });
        return view;
    }

    private void setFriendsRecyclerView() {
        friendsLayoutModelArrayList = new ArrayList<>();
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        friendsLayoutModelArrayList.add(new FriendsLayoutModel(R.drawable.ic_profile_icon_svg_gvqn3q));
        FriendsLayoutAdapter adapter = new FriendsLayoutAdapter(getContext(), friendsLayoutModelArrayList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.friendsrecyclerview.setLayoutManager(manager);
        binding.friendsrecyclerview.setAdapter(adapter);
    }

    private void activityResultLauncher(Intent intent, int type) {
        if (intent.getAction() == Intent.ACTION_GET_CONTENT) {
            if (type == 1) {
                activityResultLauncherBackgroundImage.launch(intent);
            } else {
                activityResultLauncherProfileImage.launch(intent);
            }
        } else {
            if (type == 1) {
                activityResultLauncherBackgroundImageCamera.launch(cameraUri);
            } else {
                activityResultLauncherProfileImageCamera.launch(cameraUri);
            }
        }
    }

    private void showImagePicDialogforProfile() {
        String options[] = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Pick Image From");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // if access is not given then we will request for permission
                if (which == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermission(2);
                    } else {
                        pickFromCamera(2);
                    }
                } else if (which == 1) {
                    if (!checkStoragePermission()) {
                        requestStoragePermission(2);
                    } else {
                        pickFromStorage(2);
                    }

                }
            }
        });
        builder.create().show();
    }

    private void showImagePicDialogforBackground() {
        String options[] = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Pick Image From");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // if access is not given then we will request for permission
                if (which == 0) {
                    if (!checkCameraPermission()) {
                        requestCameraPermission(1);
                    } else {
                        pickFromCamera(1);
                    }
                } else if (which == 1) {
                    if (!checkStoragePermission()) {
                        requestStoragePermission(1);
                    } else {
                        pickFromStorage(1);
                    }

                }
            }
        });
        builder.create().show();
    }


    private void pickFromCamera(int type) {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        activityResultLauncher(intent, type);
    }

    private void pickFromStorage(int type) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activityResultLauncher(intent, type);
    }

    private void requestCameraPermission(int type) {
        if (type == 1) {
            getActivityResultLauncherCameraRequestBackground.launch(Manifest.permission.CAMERA);
        } else {
            getActivityResultLauncherCameraRequestProfile.launch(Manifest.permission.CAMERA);
        }

    }

    private boolean checkCameraPermission() {

        boolean result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }


    private Boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result;
    }

    private void requestStoragePermission(int type) {
        if (type == 1) {
            getActivityResultLauncherStorageRequestBackground.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        } else {
            getActivityResultLauncherStorageRequestProfile.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    }
}