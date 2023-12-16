// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package communitycommons.actions;

import com.mendix.systemwideinterfaces.core.IMendixObject;
import communitycommons.ORM;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * Clones objects, their associations and even referred objects. 
 * 
 * - Source: the original object to copy
 * - Target: the object to copy it into (should be of the same type, or a specialization)
 * - MembersToSkip: members which should not  be set at all
 * - MembersToKeep: references which should be set, but not cloned. (so source and target will refer to exactly the same object). If an association is not part of this property, it will be cloned.
 * - ReverseAssociations: 1 - 0 assications which refer to target, which will be cloned as well. Only the reference name itself needs to be mentioned.
 * - excludeEntities: entities that will not be cloned. references to these entities will refer to the same object as the source did.
 * - excludeModules: modules that will have none of their enities cloned. Behaves similar to excludeEntities.
 * 
 * members format: <membername> or <module.association> or <module.objecttype/membername>, where objecttype is the concrete type of the object being cloned. 
 * 
 * reverseAssociation: 
 * <module.relation>
 * 
 * membersToSkip by automatically contains createdDate and changedDate. 
 * membersToKeep by automatically contains System.owner and System.changedBy
 * 
 * Note that DeepClone does commit all objects, where Clone does not.
 */
public class DeepClone extends CustomJavaAction<java.lang.Boolean>
{
	private final IMendixObject source;
	private final IMendixObject target;
	private final java.lang.String membersToSkip;
	private final java.lang.String membersToKeep;
	private final java.lang.String reverseAssociations;
	private final java.lang.String excludeEntities;
	private final java.lang.String excludeModules;

	public DeepClone(
		IContext context,
		IMendixObject _source,
		IMendixObject _target,
		java.lang.String _membersToSkip,
		java.lang.String _membersToKeep,
		java.lang.String _reverseAssociations,
		java.lang.String _excludeEntities,
		java.lang.String _excludeModules
	)
	{
		super(context);
		this.source = _source;
		this.target = _target;
		this.membersToSkip = _membersToSkip;
		this.membersToKeep = _membersToKeep;
		this.reverseAssociations = _reverseAssociations;
		this.excludeEntities = _excludeEntities;
		this.excludeModules = _excludeModules;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		java.lang.String membersToSkip       = this.membersToSkip == null       ? "" : this.membersToSkip;
		java.lang.String membersToKeep       = this.membersToKeep == null       ? "" : this.membersToKeep;
		java.lang.String reverseAssociations = this.reverseAssociations == null ? "" : this.reverseAssociations;
		java.lang.String excludeEntities     = this.excludeEntities == null     ? "" : this.excludeEntities;
		java.lang.String excludeModules      = this.excludeModules == null      ? "" : this.excludeModules;

		ORM.deepClone(getContext(), source, target, membersToSkip, membersToKeep, reverseAssociations, excludeEntities, excludeModules);
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "DeepClone";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
