package com.pfliu.translate.view;

import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.part.WorkbenchPart;

import com.pfliu.translate.util.TransUtil;

/**  
 * 类名: Translate  
 * 作者： pfliu
 * 日期: 2019年4月3日
 * 时间：下午6:10:09                
 */
public class Translate extends ViewPart{

    public static final String ID="com.pfliu.translate.view.Translate";

    public static volatile StyledText resultText;
    
    public void createPartControl(Composite parent) {
        resultText=new StyledText(parent, 0);
    }
    /**  
     * translate:翻译.   
     * @author pfliu    
     */
    public static void  translate() {
        IWorkbenchPartSite activePage=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService().getActivePart().getSite();
        IEditorPart editorPart=activePage.getWorkbenchWindow().getActivePage().getActiveEditor();
        if(editorPart!=null) {
            ITextOperationTarget  target=((WorkbenchPart) editorPart).getAdapter(ITextOperationTarget.class);
            if (target instanceof ITextViewer) {
                ITextViewer textViewer = (ITextViewer)target;
                String text = textViewer.getTextWidget().getSelectionText();
                System.out.println(text);
                resultText.setText("原文：" + text + "\r\n译文：" + TransUtil.getTransResult(text, "auto", "zh"));
            }
        }

    }
    @Override
    public void setFocus()
    {
        // TODO Auto-generated method stub  
        
    }
   

}
  
