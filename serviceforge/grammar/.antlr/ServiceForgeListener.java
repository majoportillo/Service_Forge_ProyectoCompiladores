// Generated from c:/Users/ergil/Documents/Tareas Septimo Semestre/Compiladores/Proyecto/Service_Forge_ProyectoCompiladores/serviceforge/grammar/ServiceForge.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ServiceForgeParser}.
 */
public interface ServiceForgeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ServiceForgeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ServiceForgeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#apiBlock}.
	 * @param ctx the parse tree
	 */
	void enterApiBlock(ServiceForgeParser.ApiBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#apiBlock}.
	 * @param ctx the parse tree
	 */
	void exitApiBlock(ServiceForgeParser.ApiBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#apiOption}.
	 * @param ctx the parse tree
	 */
	void enterApiOption(ServiceForgeParser.ApiOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#apiOption}.
	 * @param ctx the parse tree
	 */
	void exitApiOption(ServiceForgeParser.ApiOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#resourceBlock}.
	 * @param ctx the parse tree
	 */
	void enterResourceBlock(ServiceForgeParser.ResourceBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#resourceBlock}.
	 * @param ctx the parse tree
	 */
	void exitResourceBlock(ServiceForgeParser.ResourceBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#fieldsLine}.
	 * @param ctx the parse tree
	 */
	void enterFieldsLine(ServiceForgeParser.FieldsLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#fieldsLine}.
	 * @param ctx the parse tree
	 */
	void exitFieldsLine(ServiceForgeParser.FieldsLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void enterFieldDef(ServiceForgeParser.FieldDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#fieldDef}.
	 * @param ctx the parse tree
	 */
	void exitFieldDef(ServiceForgeParser.FieldDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(ServiceForgeParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(ServiceForgeParser.DataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(ServiceForgeParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(ServiceForgeParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#endpointLine}.
	 * @param ctx the parse tree
	 */
	void enterEndpointLine(ServiceForgeParser.EndpointLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#endpointLine}.
	 * @param ctx the parse tree
	 */
	void exitEndpointLine(ServiceForgeParser.EndpointLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#httpMethod}.
	 * @param ctx the parse tree
	 */
	void enterHttpMethod(ServiceForgeParser.HttpMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#httpMethod}.
	 * @param ctx the parse tree
	 */
	void exitHttpMethod(ServiceForgeParser.HttpMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#endpointOption}.
	 * @param ctx the parse tree
	 */
	void enterEndpointOption(ServiceForgeParser.EndpointOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#endpointOption}.
	 * @param ctx the parse tree
	 */
	void exitEndpointOption(ServiceForgeParser.EndpointOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(ServiceForgeParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(ServiceForgeParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#returnModifier}.
	 * @param ctx the parse tree
	 */
	void enterReturnModifier(ServiceForgeParser.ReturnModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#returnModifier}.
	 * @param ctx the parse tree
	 */
	void exitReturnModifier(ServiceForgeParser.ReturnModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#relationshipLine}.
	 * @param ctx the parse tree
	 */
	void enterRelationshipLine(ServiceForgeParser.RelationshipLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#relationshipLine}.
	 * @param ctx the parse tree
	 */
	void exitRelationshipLine(ServiceForgeParser.RelationshipLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ServiceForgeParser#relType}.
	 * @param ctx the parse tree
	 */
	void enterRelType(ServiceForgeParser.RelTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ServiceForgeParser#relType}.
	 * @param ctx the parse tree
	 */
	void exitRelType(ServiceForgeParser.RelTypeContext ctx);
}