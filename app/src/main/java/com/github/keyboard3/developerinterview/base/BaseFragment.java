package com.github.keyboard3.developerinterview.base;


import android.app.Fragment;
import android.app.ProgressDialog;

import com.github.keyboard3.developerinterview.R;
import com.github.keyboard3.developerinterview.base.IProgressDialog;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * A BaseFragment {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements IProgressDialog {
    private ProgressDialog mProgressDialog;
    private AVLoadingIndicatorView mAdvanceProgressView;

    private boolean mAdvanceDialogToggle;

    protected void toggleDialogAdvance(boolean toggle) {
        mAdvanceDialogToggle = toggle;
    }

    @Override
    public void showDialog() {
        if (mAdvanceDialogToggle && mAdvanceProgressView == null) {
            mAdvanceProgressView = getView().findViewById(R.id.avi);
        } else if (!mAdvanceDialogToggle && mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage(getString(R.string.com_loading));
            mProgressDialog.setIndeterminate(true);
        }
        if (mAdvanceDialogToggle) {
            mAdvanceProgressView.show();
        } else {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideDialog() {
        if (mAdvanceDialogToggle && mAdvanceProgressView != null) {
            mAdvanceProgressView.hide();
        } else if ((mAdvanceDialogToggle == false || mAdvanceProgressView == null) && mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }

    @Override
    public boolean isShowing() {
        return mProgressDialog.isShowing();
    }
}
