package nth.reflect.example.domain.classdiagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nth.reflect.fw.generic.util.TypeUtil;
import nth.reflect.fw.layer5provider.reflection.ReflectionProvider;
import nth.reflect.fw.layer5provider.reflection.behavior.executionmode.ExecutionMode;
import nth.reflect.fw.layer5provider.reflection.behavior.executionmode.ExecutionModeType;
import nth.reflect.fw.layer5provider.reflection.info.actionmethod.ActionMethodInfo;
import nth.reflect.fw.layer5provider.reflection.info.classinfo.ClassInfo;
import nth.reflect.fw.layer5provider.reflection.info.property.PropertyInfo;

public class ClassDiagramService {

	private final List<Class<?>> serviceClasses;
	private final ReflectionProvider reflectionProvider;

	public ClassDiagramService(ReflectionProvider reflectionProvider) {
		this.reflectionProvider = reflectionProvider;
		serviceClasses = new ArrayList<Class<?>>();
		serviceClasses.add(ClassDiagram.class);
	}

	public List<ClassFeature> allServiceClasses() {
		List<ClassFeature> classFeatures = new ArrayList<ClassFeature>();
		for (Class<?> serviceClass : serviceClasses) {
			classFeatures.add(new ClassFeature(serviceClass));
		}
		return classFeatures;
	}

	public List<ClassFeature> allClasses() {
		Set<Class<?>> foundClasses = new HashSet<Class<?>>();

		for (Class<?> serviceClass : serviceClasses) {
			// Task task=notificationProvider.addNewTask("Finding classes",
			// index, maxValue);
			getReferencedClasses(reflectionProvider, serviceClass, foundClasses);
		}

		List<ClassFeature> classFeatures = new ArrayList<ClassFeature>();
		for (Class<?> clazz : foundClasses) {
			classFeatures.add(new ClassFeature(clazz));
		}
		Collections.sort(classFeatures, new Comparator<ClassFeature>() {

			@Override
			public int compare(ClassFeature classFeature1,
					ClassFeature classFeature2) {
				return classFeature1.toString().compareTo(
						classFeature2.toString());
			}
		});

		// notificationProvider.remove(task)

		return classFeatures;
	}

	private void getReferencedClasses(ReflectionProvider reflectionProvider,
			Class<? extends Object> clazz, Set<Class<?>> foundClasses) {
		if (clazz != null && !foundClasses.contains(clazz)
				&& !TypeUtil.isJavaType(clazz) && !TypeUtil.isVoidType(clazz)) {
			foundClasses.add(clazz);
			System.out.println(clazz.getCanonicalName());

			ClassInfo classInfo = reflectionProvider.getClassInfo(clazz);
			
			List<PropertyInfo> propertyInfos = classInfo.getPropertyInfosSorted();
			for (PropertyInfo propertyInfo : propertyInfos) {
				Class<?> propertyType = propertyInfo.getPropertyType()
						.getType();
				getReferencedClasses(reflectionProvider, propertyType,
						foundClasses);// recursive call
			}

			List<ActionMethodInfo> actionMethodInfos = classInfo.getActionMethodInfosSorted();
			for (ActionMethodInfo actionMethodInfo : actionMethodInfos) {
				Class<?> returnType = actionMethodInfo.getGenericReturnType();
				getReferencedClasses(reflectionProvider, returnType,
						foundClasses);// recursive call

				Class<?> parameterType = actionMethodInfo.getGenericParameterType();
				getReferencedClasses(reflectionProvider, parameterType,
						foundClasses);// recursive call
			}
		}
	}

	// @FormMode(FormModeType.editParameterThenExecuteMethodOrCancel)
	// public ClassDiagram testClassDiagram() {
	// ClassDiagram classDiagram = new ClassDiagram(AllTypeDomainObject.class);
	// return classDiagram;
	// }

	@ExecutionMode(mode = ExecutionModeType.EXECUTE_METHOD_DIRECTLY)
	public ClassDiagram openClassDiagram(ClassFeature classFeature) {
		Class<?> objectClass = classFeature.getType();
		if (objectClass == null) {
			// a method without a return value (void) or without a parameter
			// does not have a type!
			throw new RuntimeException(classFeature.toString()
					+ " does not have a type reference.");
		} else {
			ClassDiagram classDiagram = new ClassDiagram(reflectionProvider,
					objectClass);
			return classDiagram;
		}
	}

	// public void createClassDiagramReport() {
	// // TODO
	// }
}
