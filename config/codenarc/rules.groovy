ruleset {

    description 'All Groovy CodeNarc rules, grouped by category'

    ruleset('rulesets/basic.xml')

    /*
    AssertWithinFinallyBlock
    AssignmentInConditional
    BigDecimalInstantiation
    BitwiseOperatorInConditional
    BooleanGetBoolean
    BrokenNullCheck
    BrokenOddnessCheck
    ClassForName
    ComparisonOfTwoConstants
    ComparisonWithSelf
    ConstantAssertExpression
    ConstantIfExpression
    ConstantTernaryExpression
    DeadCode
    DoubleNegative
    DuplicateCaseStatement
    DuplicateMapKey
    DuplicateSetValue
    EmptyCatchBlock
    EmptyClass
    EmptyElseBlock
    EmptyFinallyBlock
    EmptyForStatement
    EmptyIfStatement
    EmptyInstanceInitializer
    EmptyMethod
    EmptyStaticInitializer
    EmptySwitchStatement
    EmptySynchronizedStatement
    EmptyTryBlock
    EmptyWhileStatement
    EqualsAndHashCode
    EqualsOverloaded
    ExplicitGarbageCollection
    ForLoopShouldBeWhileLoop
    HardCodedWindowsFileSeparator
    HardCodedWindowsRootDirectory
    IntegerGetInteger
    MultipleUnaryOperators
    RandomDoubleCoercedToZero
    RemoveAllOnSelf
    ReturnFromFinallyBlock
    ThrowExceptionFromFinallyBlock
    */

    ruleset('rulesets/braces.xml')

    /*
    ElseBlockBraces
    ForStatementBraces
    IfStatementBraces
    WhileStatementBraces
    */

    ruleset('rulesets/comments.xml')

    /*
    ClassJavadoc
    JavadocConsecutiveEmptyLines
    JavadocEmptyAuthorTag
    JavadocEmptyExceptionTag
    JavadocEmptyFirstLine
    JavadocEmptyLastLine
    JavadocEmptyParamTag
    JavadocEmptyReturnTag
    JavadocEmptySeeTag
    JavadocEmptySinceTag
    JavadocEmptyThrowsTag
    JavadocEmptyVersionTag
    JavadocMissingExceptionDescription
    JavadocMissingParamDescription
    JavadocMissingThrowsDescription
    */

    ruleset('rulesets/concurrency.xml')

    /*
    BusyWait
    DoubleCheckedLocking
    InconsistentPropertyLocking
    InconsistentPropertySynchronization
    NestedSynchronization
    StaticCalendarField
    StaticConnection
    StaticDateFormatField
    StaticMatcherField
    StaticSimpleDateFormatField
    SynchronizedMethod
    SynchronizedOnBoxedPrimitive
    SynchronizedOnGetClass
    SynchronizedOnReentrantLock
    SynchronizedOnString
    SynchronizedOnThis
    SynchronizedReadObjectMethod
    SystemRunFinalizersOnExit
    ThisReferenceEscapesConstructor
    ThreadGroup
    ThreadLocalNotStaticFinal
    ThreadYield
    UseOfNotifyMethod
    VolatileArrayField
    VolatileLongOrDoubleField
    WaitOutsideOfWhileLoop
    */

    ruleset('rulesets/convention.xml') {
        MethodReturnTypeRequired {
            doNotApplyToClassNames = '*Test'
        }
        NoDef {
            doNotApplyToClassNames = '*Test'
        }
    }

    /*
    CompileStatic
    ConfusingTernary
    CouldBeElvis
    CouldBeSwitchStatement
    FieldTypeRequired
    HashtableIsObsolete
    IfStatementCouldBeTernary
    ImplicitClosureParameter
    InvertedCondition
    InvertedIfElse
    LongLiteralWithLowerCaseL
    MethodParameterTypeRequired
    MethodReturnTypeRequired
    NoDef
    NoDouble
    NoFloat
    NoJavaUtilDate
    NoTabCharacter
    ParameterReassignment
    PublicMethodsBeforeNonPublicMethods
    StaticFieldsBeforeInstanceFields
    StaticMethodsBeforeInstanceMethods
    TernaryCouldBeElvis
    TrailingComma
    VariableTypeRequired
    VectorIsObsolete
    */

    ruleset('rulesets/design.xml')

    /*
    AbstractClassWithPublicConstructor
    AbstractClassWithoutAbstractMethod
    AssignmentToStaticFieldFromInstanceMethod
    BooleanMethodReturnsNull
    BuilderMethodWithSideEffects
    CloneableWithoutClone
    CloseWithoutCloseable
    CompareToWithoutComparable
    ConstantsOnlyInterface
    EmptyMethodInAbstractClass
    FinalClassWithProtectedMember
    ImplementationAsType
    Instanceof
    LocaleSetDefault
    NestedForLoop
    PrivateFieldCouldBeFinal
    PublicInstanceField
    ReturnsNullInsteadOfEmptyArray
    ReturnsNullInsteadOfEmptyCollection
    SimpleDateFormatMissingLocale
    StatelessSingleton
    ToStringReturnsNull
    */

    ruleset('rulesets/dry.xml')

    /*
    DuplicateListLiteral
    DuplicateMapLiteral
    DuplicateNumberLiteral
    DuplicateStringLiteral
    */

    // ruleset('rulesets/enhanced.xml')

    /*
    CloneWithoutCloneable
    JUnitAssertEqualsConstantActualValue
    MissingOverrideAnnotation
    UnsafeImplementationAsMap
    */

    ruleset('rulesets/exceptions.xml')

    /*
    CatchArrayIndexOutOfBoundsException
    CatchError
    CatchException
    CatchIllegalMonitorStateException
    CatchIndexOutOfBoundsException
    CatchNullPointerException
    CatchRuntimeException
    CatchThrowable
    ConfusingClassNamedException
    ExceptionExtendsError
    ExceptionExtendsThrowable
    ExceptionNotThrown
    MissingNewInThrowStatement
    ReturnNullFromCatchBlock
    SwallowThreadDeath
    ThrowError
    ThrowException
    ThrowNullPointerException
    ThrowRuntimeException
    ThrowThrowable
    */

    ruleset('rulesets/formatting.xml') {
        Indentation {
            spacesPerIndentLevel = 2
        }
        LineLength {
            length = 80
        }
        SpaceAroundMapEntryColon {
            characterAfterColonRegex = '\\s'
        }
    }

    /*
    BlankLineBeforePackage
    BlockEndsWithBlankLine
    BlockStartsWithBlankLine
    BracesForClass
    BracesForForLoop
    BracesForIfElse
    BracesForMethod
    BracesForTryCatchFinally
    ClassEndsWithBlankLine
    ClassStartsWithBlankLine
    ClosureStatementOnOpeningLineOfMultipleLineClosure
    ConsecutiveBlankLines
    FileEndsWithoutNewline
    Indentation
    LineLength
    MissingBlankLineAfterImports
    MissingBlankLineAfterPackage
    SpaceAfterCatch
    SpaceAfterClosingBrace
    SpaceAfterComma
    SpaceAfterFor
    SpaceAfterIf
    SpaceAfterOpeningBrace
    SpaceAfterSemicolon
    SpaceAfterSwitch
    SpaceAfterWhile
    SpaceAroundClosureArrow
    SpaceAroundMapEntryColon
    SpaceAroundOperator
    SpaceBeforeClosingBrace
    SpaceBeforeOpeningBrace
    TrailingWhitespace
    */

    ruleset('rulesets/generic.xml')

    /*
    IllegalClassMember
    IllegalClassReference
    IllegalPackageReference
    IllegalRegex
    IllegalString
    IllegalSubclass
    RequiredRegex
    RequiredString
    StatelessClass
    */

    // ruleset('rulesets/grails.xml')

    /*
    GrailsDomainHasEquals
    GrailsDomainHasToString
    GrailsDomainReservedSqlKeywordName
    GrailsDomainStringPropertyMaxSize
    GrailsDomainWithServiceReference
    GrailsDuplicateConstraint
    GrailsDuplicateMapping
    GrailsMassAssignment
    GrailsPublicControllerMethod
    GrailsServletContextReference
    GrailsStatelessService
    */

    ruleset('rulesets/groovyism.xml')

    /*
    AssignCollectionSort
    AssignCollectionUnique
    ClosureAsLastMethodParameter
    CollectAllIsDeprecated
    ConfusingMultipleReturns
    ExplicitArrayListInstantiation
    ExplicitCallToAndMethod
    ExplicitCallToCompareToMethod
    ExplicitCallToDivMethod
    ExplicitCallToEqualsMethod
    ExplicitCallToGetAtMethod
    ExplicitCallToLeftShiftMethod
    ExplicitCallToMinusMethod
    ExplicitCallToModMethod
    ExplicitCallToMultiplyMethod
    ExplicitCallToOrMethod
    ExplicitCallToPlusMethod
    ExplicitCallToPowerMethod
    ExplicitCallToPutAtMethod
    ExplicitCallToRightShiftMethod
    ExplicitCallToXorMethod
    ExplicitHashMapInstantiation
    ExplicitHashSetInstantiation
    ExplicitLinkedHashMapInstantiation
    ExplicitLinkedListInstantiation
    ExplicitStackInstantiation
    ExplicitTreeSetInstantiation
    GStringAsMapKey
    GStringExpressionWithinString
    GetterMethodCouldBeProperty
    GroovyLangImmutable
    UseCollectMany
    UseCollectNested
    */

    ruleset('rulesets/imports.xml')

    /*
    DuplicateImport
    ImportFromSamePackage
    ImportFromSunPackages
    MisorderedStaticImports
    NoWildcardImports
    UnnecessaryGroovyImport
    UnusedImport
    */

    ruleset('rulesets/jdbc.xml')

    /*
    DirectConnectionManagement
    JdbcConnectionReference
    JdbcResultSetReference
    JdbcStatementReference
    */

    // ruleset('rulesets/junit.xml')

    /*
    ChainedTest
    CoupledTestCase
    JUnitAssertAlwaysFails
    JUnitAssertAlwaysSucceeds
    JUnitFailWithoutMessage
    JUnitLostTest
    JUnitPublicField
    JUnitPublicNonTestMethod
    JUnitPublicProperty
    JUnitSetUpCallsSuper
    JUnitStyleAssertions
    JUnitTearDownCallsSuper
    JUnitTestMethodWithoutAssert
    JUnitUnnecessarySetUp
    JUnitUnnecessaryTearDown
    JUnitUnnecessaryThrowsException
    SpockIgnoreRestUsed
    UnnecessaryFail
    UseAssertEqualsInsteadOfAssertTrue
    UseAssertFalseInsteadOfNegation
    UseAssertNullInsteadOfAssertEquals
    UseAssertSameInsteadOfAssertTrue
    UseAssertTrueInsteadOfAssertEquals
    UseAssertTrueInsteadOfNegation
    */

    ruleset('rulesets/logging.xml')

    /*
    LoggerForDifferentClass
    LoggerWithWrongModifiers
    LoggingSwallowsStacktrace
    MultipleLoggers
    PrintStackTrace
    Println
    SystemErrPrint
    SystemOutPrint
    */

    ruleset('rulesets/naming.xml') {
        MethodName {
            doNotApplyToClassNames = '*Test'
        }
    }

    /*
    AbstractClassName
    ClassName
    ClassNameSameAsFilename
    ClassNameSameAsSuperclass
    ConfusingMethodName
    FactoryMethodName
    FieldName
    InterfaceName
    InterfaceNameSameAsSuperInterface
    MethodName
    ObjectOverrideMisspelledMethodName
    PackageName
    PackageNameMatchesFilePath
    ParameterName
    PropertyName
    VariableName
    */

    ruleset('rulesets/security.xml') {
        exclude 'JavaIoPackageAccess'
    }

    /*
    FileCreateTempFile
    InsecureRandom
    JavaIoPackageAccess
    NonFinalPublicField
    NonFinalSubclassOfSensitiveInterface
    ObjectFinalize
    PublicFinalizeMethod
    SystemExit
    UnsafeArrayDeclaration
    */

    ruleset('rulesets/serialization.xml')

    /*
    EnumCustomSerializationIgnored
    SerialPersistentFields
    SerialVersionUID
    SerializableClassMustDefineSerialVersionUID
    */

    // ruleset('rulesets/size.xml')

    /*
    AbcMetric   // Requires the GMetrics jar
    ClassSize
    CrapMetric   // Requires the GMetrics jar and a Cobertura coverage file
    CyclomaticComplexity   // Requires the GMetrics jar
    MethodCount
    MethodSize
    NestedBlockDepth
    ParameterCount
    */

    ruleset('rulesets/unnecessary.xml')

    /*
    AddEmptyString
    ConsecutiveLiteralAppends
    ConsecutiveStringConcatenation
    UnnecessaryBigDecimalInstantiation
    UnnecessaryBigIntegerInstantiation
    UnnecessaryBooleanExpression
    UnnecessaryBooleanInstantiation
    UnnecessaryCallForLastElement
    UnnecessaryCallToSubstring
    UnnecessaryCast
    UnnecessaryCatchBlock
    UnnecessaryCollectCall
    UnnecessaryCollectionCall
    UnnecessaryConstructor
    UnnecessaryDefInFieldDeclaration
    UnnecessaryDefInMethodDeclaration
    UnnecessaryDefInVariableDeclaration
    UnnecessaryDotClass
    UnnecessaryDoubleInstantiation
    UnnecessaryElseStatement
    UnnecessaryFinalOnPrivateMethod
    UnnecessaryFloatInstantiation
    UnnecessaryGString
    UnnecessaryGetter
    UnnecessaryIfStatement
    UnnecessaryInstanceOfCheck
    UnnecessaryInstantiationToGetClass
    UnnecessaryIntegerInstantiation
    UnnecessaryLongInstantiation
    UnnecessaryModOne
    UnnecessaryNullCheck
    UnnecessaryNullCheckBeforeInstanceOf
    UnnecessaryObjectReferences
    UnnecessaryOverridingMethod
    UnnecessaryPackageReference
    UnnecessaryParenthesesForMethodCallWithClosure
    UnnecessaryPublicModifier
    UnnecessaryReturnKeyword
    UnnecessarySafeNavigationOperator
    UnnecessarySelfAssignment
    UnnecessarySemicolon
    UnnecessarySetter
    UnnecessaryStringInstantiation
    UnnecessarySubstring
    UnnecessaryTernaryExpression
    UnnecessaryToString
    UnnecessaryTransientModifier
    */

    ruleset('rulesets/unused.xml')

    /*
    UnusedArray
    UnusedMethodParameter
    UnusedObject
    UnusedPrivateField
    UnusedPrivateMethod
    UnusedPrivateMethodParameter
    UnusedVariable
    */

}
