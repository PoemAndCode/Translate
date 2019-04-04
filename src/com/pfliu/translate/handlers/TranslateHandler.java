package com.pfliu.translate.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.pfliu.translate.view.Translate;

import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class TranslateHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	 // 打开MyTranslateView
        try
        {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(Translate.ID);
        } catch (PartInitException e)
        {
              
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            
        }
        Translate.translate();
		return null;
	}
}
