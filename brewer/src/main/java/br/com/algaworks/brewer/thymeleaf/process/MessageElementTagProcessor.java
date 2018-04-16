package br.com.algaworks.brewer.thymeleaf.process;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class MessageElementTagProcessor extends AbstractAttributeTagProcessor {

	private static final String NOME_ATRIBUTO = "messages";
	private static final int PRECEDENCIA = 1000;

	public MessageElementTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, NOME_ATRIBUTO, true, PRECEDENCIA, true);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue, IElementTagStructureHandler structureHandler) {

		IModelFactory iModelFactory = context.getModelFactory();
		IModel model = iModelFactory.createModel();
		
		model.add(iModelFactory.createStandaloneElementTag("th:block","th:include","fragments/MensagemSucesso"));
		model.add(iModelFactory.createStandaloneElementTag("th:block","th:include","fragments/MensagensErrorValidacao"));

		structureHandler.replaceWith(model, true);
	}

}
