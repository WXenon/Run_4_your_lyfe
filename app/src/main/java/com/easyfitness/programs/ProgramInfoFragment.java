package com.easyfitness.programs;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.easyfitness.DAO.program.DAOProgram;
import com.easyfitness.DAO.program.Program;
import com.easyfitness.MainActivity;
import com.easyfitness.R;
import com.easyfitness.views.EditableInputView;
import com.onurkaganaldemir.ktoastlib.KToast;


public class ProgramInfoFragment extends Fragment {
    EditableInputView descriptionEdit = null;
    EditableInputView nameEdit = null;

    MainActivity mActivity = null;
    private DAOProgram mDb = null;
    private Program mProgram;
    private final EditableInputView.OnTextChangedListener itemOnTextChange = this::requestForSave;

    /**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */
    public static ProgramInfoFragment newInstance(String name, int templateId) {
        ProgramInfoFragment f = new ProgramInfoFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("templateId", templateId);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onStart() {
        super.onStart();

        this.getView().post(() -> {
            nameEdit.setOnTextChangeListener(itemOnTextChange);
            descriptionEdit.setOnTextChangeListener(itemOnTextChange);
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mActivity = (MainActivity) context;
    }

    public String getName() {
        return getArguments().getString("name");
    }

    private void requestForSave(View view) {
        boolean toUpdate = false;

        if (toUpdate) {
            mDb.update(mProgram);
            KToast.infoToast(getActivity(), mProgram.getName() + " updated", Gravity.BOTTOM, KToast.LENGTH_SHORT);
        }
    }

    public Fragment getFragment() {
        return this;
    }
}
