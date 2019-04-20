
package gr.confinanz.tasks.management.search;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;

import gr.confinanz.tasks.management.model.Task;

/**
 * @author Abdessamad Ben Taleb
 * 
 */
@Component(immediate = true, service = Indexer.class)
public class TaskIndexer extends BaseIndexer<Task>{

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doDelete(Task object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Document doGetDocument(Task object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, 
			String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doReindex(Task object) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
