/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.view;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;

/**
 * Container for storing additional per-view data generated by {@link View#onProvideStructure
 * View.onProvideStructure} and {@link View#onProvideAutofillStructure
 * View.onProvideAutofillStructure}.
 */
public abstract class ViewStructure {

    /**
     * Set the identifier for this view.
     *
     * @param id The view's identifier, as per {@link View#getId View.getId()}.
     * @param packageName The package name of the view's identifier, or null if there is none.
     * @param typeName The type name of the view's identifier, or null if there is none.
     * @param entryName The entry name of the view's identifier, or null if there is none.
     */
    public abstract void setId(int id, String packageName, String typeName, String entryName);

    /**
     * Set the basic dimensions of this view.
     *
     * @param left The view's left position, in pixels relative to its parent's left edge.
     * @param top The view's top position, in pixels relative to its parent's top edge.
     * @param scrollX How much the view's x coordinate space has been scrolled, in pixels.
     * @param scrollY How much the view's y coordinate space has been scrolled, in pixels.
     * @param width The view's visible width, in pixels.  This is the width visible on screen,
     * not the total data width of a scrollable view.
     * @param height The view's visible height, in pixels.  This is the height visible on
     * screen, not the total data height of a scrollable view.
     */
    public abstract void setDimens(int left, int top, int scrollX, int scrollY, int width,
            int height);

    /**
     * Set the transformation matrix associated with this view, as per
     * {@link View#getMatrix View.getMatrix()}, or null if there is none.
     */
    public abstract void setTransformation(Matrix matrix);

    /**
     * Set the visual elevation (shadow) of the view, as per
     * {@link View#getZ View.getZ()}.  Note this is <em>not</em> related
     * to the physical Z-ordering of this view relative to its other siblings (that is how
     * they overlap when drawing), it is only the visual representation for shadowing.
     */
    public abstract void setElevation(float elevation);

    /**
     * Set an alpha transformation that is applied to this view, as per
     * {@link View#getAlpha View.getAlpha()}.  Value ranges from 0
     * (completely transparent) to 1 (completely opaque); the default is 1, which means
     * no transformation.
     */
    public abstract void setAlpha(float alpha);

    /**
     * Set the visibility state of this view, as per
     * {@link View#getVisibility View.getVisibility()}.
     */
    public abstract void setVisibility(int visibility);

    /** @hide */
    public abstract void setAssistBlocked(boolean state);

    /**
     * Set the enabled state of this view, as per {@link View#isEnabled View.isEnabled()}.
     */
    public abstract void setEnabled(boolean state);

    /**
     * Set the clickable state of this view, as per {@link View#isClickable View.isClickable()}.
     */
    public abstract void setClickable(boolean state);

    /**
     * Set the long clickable state of this view, as per
     * {@link View#isLongClickable View.isLongClickable()}.
     */
    public abstract void setLongClickable(boolean state);

    /**
     * Set the context clickable state of this view, as per
     * {@link View#isContextClickable View.isContextClickable()}.
     */
    public abstract void setContextClickable(boolean state);

    /**
     * Set the focusable state of this view, as per {@link View#isFocusable View.isFocusable()}.
     */
    public abstract void setFocusable(boolean state);

    /**
     * Set the focused state of this view, as per {@link View#isFocused View.isFocused()}.
     */
    public abstract void setFocused(boolean state);

    /**
     * Set the accessibility focused state of this view, as per
     * {@link View#isAccessibilityFocused View.isAccessibilityFocused()}.
     */
    public abstract void setAccessibilityFocused(boolean state);

    /**
     * Set the checkable state of this view, such as whether it implements the
     * {@link android.widget.Checkable} interface.
     */
    public abstract void setCheckable(boolean state);

    /**
     * Set the checked state of this view, such as
     * {@link android.widget.Checkable#isChecked Checkable.isChecked()}.
     */
    public abstract void setChecked(boolean state);

    /**
     * Set the selected state of this view, as per {@link View#isSelected View.isSelected()}.
     */
    public abstract void setSelected(boolean state);

    /**
     * Set the activated state of this view, as per {@link View#isActivated View.isActivated()}.
     */
    public abstract void setActivated(boolean state);

    /**
     * Set the class name of the view, as per
     * {@link View#getAccessibilityClassName View.getAccessibilityClassName()}.
     */
    public abstract void setClassName(String className);

    /**
     * Set the content description of the view, as per
     * {@link View#getContentDescription View.getContentDescription()}.
     */
    public abstract void setContentDescription(CharSequence contentDescription);

    /**
     * Set the text that is associated with this view.  There is no selection
     * associated with the text.  The text may have style spans to supply additional
     * display and semantic information.
     */
    public abstract void setText(CharSequence text);

    /**
     * Like {@link #setText(CharSequence)} but with an active selection
     * extending from <var>selectionStart</var> through <var>selectionEnd</var>.
     */
    public abstract void setText(CharSequence text, int selectionStart, int selectionEnd);

    /**
     * Explicitly set default global style information for text that was previously set with
     * {@link #setText}.
     *
     * @param size The size, in pixels, of the text.
     * @param fgColor The foreground color, packed as 0xAARRGGBB.
     * @param bgColor The background color, packed as 0xAARRGGBB.
     * @param style Style flags, as defined by {@link android.app.assist.AssistStructure.ViewNode}.
     */
    public abstract void setTextStyle(float size, int fgColor, int bgColor, int style);

    /**
     * Set line information for test that was previously supplied through
     * {@link #setText(CharSequence)}.  This provides the line breaking of the text as it
     * is shown on screen.  This function takes ownership of the provided arrays; you should
     * not make further modification to them.
     *
     * @param charOffsets The offset in to {@link #setText} where a line starts.
     * @param baselines The baseline where the line is drawn on screen.
     */
    public abstract void setTextLines(int[] charOffsets, int[] baselines);

    /**
     * Set optional hint text associated with this view; this is for example the text that is
     * shown by an EditText when it is empty to indicate to the user the kind of text to input.
     */
    public abstract void setHint(CharSequence hint);

    /**
     * Retrieve the last {@link #setText(CharSequence)}.
     */
    public abstract CharSequence getText();

    /**
     * Retrieve the last selection start set by {@link #setText(CharSequence, int, int)}.
     */
    public abstract int getTextSelectionStart();

    /**
     * Retrieve the last selection end set by {@link #setText(CharSequence, int, int)}.
     */
    public abstract int getTextSelectionEnd();

    /**
     * Retrieve the last hint set by {@link #setHint}.
     */
    public abstract CharSequence getHint();

    /**
     * Get extra data associated with this view structure; the returned Bundle is mutable,
     * allowing you to view and modify its contents.  Keys placed in the Bundle should use
     * an appropriate namespace prefix (such as com.google.MY_KEY) to avoid conflicts.
     */
    public abstract Bundle getExtras();

    /**
     * Returns true if {@link #getExtras} has been used to create extra content.
     */
    public abstract boolean hasExtras();

    /**
     * Set the number of children of this view, which defines the range of indices you can
     * use with {@link #newChild} and {@link #asyncNewChild}.  Calling this method again
     * resets all of the child state of the view, removing any children that had previously
     * been added.
     */
    public abstract void setChildCount(int num);

    /**
     * Add to this view's child count.  This increases the current child count by
     * <var>num</var> children beyond what was last set by {@link #setChildCount}
     * or {@link #addChildCount}.  The index at which the new child starts in the child
     * array is returned.
     *
     * @param num The number of new children to add.
     * @return Returns the index in the child array at which the new children start.
     */
    public abstract int addChildCount(int num);

    /**
     * Return the child count as set by {@link #setChildCount}.
     */
    public abstract int getChildCount();

    /**
     * Create a new child {@link ViewStructure} in this view, putting into the list of
     * children at <var>index</var>.
     *
     * @return Returns an fresh {@link ViewStructure} ready to be filled in.
     */
    public abstract ViewStructure newChild(int index);

    /**
     * Create a new child {@link ViewStructure} in this view for autofill purposes.
     *
     * @param index the index (in the list of children) to put the new child at (see
     *            {@link #addChildCount(int)} and {@link #setChildCount(int)}.
     * @param virtualId an opaque ID to the Android System (although it could be meaningful to the
     *            {@link View} creating the {@link ViewStructure}), but it's the same id used on
     *            {@link View#autofillVirtual(int, AutofillValue)}.
     * @param flags currently {@code 0}.
     *
     * @return Returns an fresh {@link ViewStructure} ready to be filled in.
     */
    // TODO(b/33197203, b/33802548): add CTS/unit test
    public abstract ViewStructure newChildForAutofill(int index, int virtualId, int flags);

    /**
     * Like {@link #newChild}, but allows the caller to asynchronously populate the returned
     * child.  It can transfer the returned {@link ViewStructure} to another thread for it
     * to build its content (and children etc).  Once done, some thread must call
     * {@link #asyncCommit} to tell the containing {@link ViewStructure} that the async
     * population is done.
     * @return Returns an fresh {@link ViewStructure} ready to be filled in.
     */
    public abstract ViewStructure asyncNewChild(int index);

    /**
     * Like {@link #newChildForAutofill(int, int, int)}, but allows the caller to asynchronously
     * populate the returned child.
     *
     * <p>It can transfer the returned {@link ViewStructure} to another thread for it to build its
     * content (and children etc).
     *
     * <p>Once done, some thread must call {@link #asyncCommit()} to tell the containing
     * {@link ViewStructure} that the async population is done.
     *
     * @param index the index (in the list of children) to put the new child at (see
     *            {@link #addChildCount(int)} and {@link #setChildCount(int)}.
     * @param virtualId an opaque ID to the Android System (although it could be meaningful to the
     *            {@link View} creating the {@link ViewStructure}), but it's the same id used on
     *            {@link View#autofillVirtual(int, AutofillValue)}.
     * @param flags currently {@code 0}.
     *
     * @return Returns an fresh {@link ViewStructure} ready to be filled in.
     */
    // TODO(b/33197203, b/33802548): add CTS/unit test
    public abstract ViewStructure asyncNewChildForAutofill(int index, int virtualId, int flags);

    /**
     * Sets the {@link View#getAutofillType()} that can be used to autofill this node.
     */
    public abstract void setAutofillType(@View.AutofillType int type);

    /**
     * Sets the a hint that helps the autofill service to select the appropriate data to fill the
     * view.
     */
    public abstract void setAutofillHint(@View.AutofillHint int hint);

    /**
     * Sets the {@link AutofillValue} representing the current value of this node.
     */
    public abstract void setAutofillValue(AutofillValue value);

    /**
     * Sets the options that can be used to autofill this node.
     *
     * <p>Typically used by nodes whose {@link View#getAutofillType()} is a list to indicate the
     * meaning of each possible value in the list.
     */
    public abstract void setAutofillOptions(String[] options);

    /**
     * Sets the {@link android.text.InputType} bits of this node.
     *
     * @param inputType inputType bits as defined by {@link android.text.InputType}.
     */
    public abstract void setInputType(int inputType);

    /**
     * Marks this node as sanitized so its content are sent on {@link
     * android.service.autofill.AutofillService#onFillRequest(android.app.assist.AssistStructure,
     * Bundle, android.os.CancellationSignal, android.service.autofill.FillCallback)}.
     *
     * <p>Only nodes that does not have PII (Personally Identifiable Information - sensitive data
     * such as email addresses, credit card numbers, passwords, etc...) should be marked
     * as sanitized; a good rule of thumb is to mark as sanitized nodes whose value were statically
     * set from resources.
     *
     * <p>Should only be set when the node is used for autofill purposes - it will be ignored
     * when used for Assist.
     */
    public abstract void setSanitized(boolean sanitized);

    /**
     * Call when done populating a {@link ViewStructure} returned by
     * {@link #asyncNewChild}.
     */
    public abstract void asyncCommit();

    /** @hide */
    public abstract Rect getTempRect();

    /** @hide */
    public abstract void setAutofillId(int viewId);

    /** @hide */
    public abstract AutofillId getAutofillId();

    /**
     * Sets the URL represented by this node.
     *
     * <p>Typically used in the following situations:
     *
     * <ol>
     * <li>In a {@link android.app.assist.AssistStructure.WindowNode#getRootViewNode()}, to set up
     * the main URL of an HTML page.
     * <li>On child nodes represening hyperlinks.
     * </ol>
     */
    public abstract void setUrl(String url);
}
