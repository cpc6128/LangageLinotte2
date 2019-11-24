package org.linotte.moteur.xml.analyse.multilangage.linnet;

import org.linotte.frame.coloration.StyleItem;
import org.linotte.frame.coloration.StyleItem.STYLE;
import org.linotte.moteur.xml.analyse.multilangage.MathematiqueOperation;
import org.linotte.moteur.xml.analyse.multilangage.TypeSyntaxe;
import org.linotte.moteur.xml.operation.binaire.ATan2;
import org.linotte.moteur.xml.operation.binaire.Diff;
import org.linotte.moteur.xml.operation.binaire.Egal;
import org.linotte.moteur.xml.operation.binaire.Et;
import org.linotte.moteur.xml.operation.binaire.Inf;
import org.linotte.moteur.xml.operation.binaire.Mod;
import org.linotte.moteur.xml.operation.binaire.Ou;
import org.linotte.moteur.xml.operation.binaire.Puiss;
import org.linotte.moteur.xml.operation.binaire.Rd;
import org.linotte.moteur.xml.operation.binaire.Rg;
import org.linotte.moteur.xml.operation.binaire.Sup;
import org.linotte.moteur.xml.operation.binaire.Xou;
import org.linotte.moteur.xml.operation.i.Operation;
import org.linotte.moteur.xml.operation.ternaire.Ter;
import org.linotte.moteur.xml.operation.unaire.ACos;
import org.linotte.moteur.xml.operation.unaire.ASin;
import org.linotte.moteur.xml.operation.unaire.ATan;
import org.linotte.moteur.xml.operation.unaire.Abs;
import org.linotte.moteur.xml.operation.unaire.Arrondi;
import org.linotte.moteur.xml.operation.unaire.Ascii;
import org.linotte.moteur.xml.operation.unaire.Carre;
import org.linotte.moteur.xml.operation.unaire.Chr;
import org.linotte.moteur.xml.operation.unaire.Clone;
import org.linotte.moteur.xml.operation.unaire.Cos;
import org.linotte.moteur.xml.operation.unaire.Cube;
import org.linotte.moteur.xml.operation.unaire.Decimal;
import org.linotte.moteur.xml.operation.unaire.Entier;
import org.linotte.moteur.xml.operation.unaire.Hasard;
import org.linotte.moteur.xml.operation.unaire.Log;
import org.linotte.moteur.xml.operation.unaire.LogN;
import org.linotte.moteur.xml.operation.unaire.Non;
import org.linotte.moteur.xml.operation.unaire.Racine;
import org.linotte.moteur.xml.operation.unaire.Sin;
import org.linotte.moteur.xml.operation.unaire.Tan;

public enum MathematiqueLinnet implements MathematiqueOperation {

	// Type 1
	hasard("random", Hasard.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	carre("square", Carre.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	sin("sin", Sin.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	asin("asin", ASin.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	acos("acos", ACos.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	cos("cos", Cos.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	entier("floor", Entier.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	decimal("decimal", Decimal.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	arrondi("round", Arrondi.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	tan("tan", Tan.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	atan2("atan2", ATan2.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	atan("atan", ATan.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	log("log", Log.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	logn("logn", LogN.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	abs("abs", Abs.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	racine("sqr", Racine.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	cube("cube", Cube.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	non("not", Non.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	ascii("ascii", Ascii.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	chr("chr", Chr.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	ter("ter", Ter.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	ternaire("ternaire", Ter.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	clone("clone", Clone.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_1),
	
	// Type 2
	puiss("pow", Puiss.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	mod("mod", Mod.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	rg("rg", Rg.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	rd("rd", Rd.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	et("and", Et.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	sup("gt", Sup.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	égal("eq", Egal.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	inf("lt", Inf.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	diff("ne", Diff.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	ou("or", Ou.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	xou("xor", Xou.class, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_2),
	
	// Type 3 : visible de toile
	de("of", null, StyleItem.STYLE.MATH, TypeSyntaxe.TYPE_3),

	;
	private String texte;
	private Class<? extends Operation> operation;
	private StyleItem.STYLE style;
	private TypeSyntaxe typeSyntaxe;

	private MathematiqueLinnet(String texte, Class<? extends Operation> operation, StyleItem.STYLE style, TypeSyntaxe typeSyntaxe) {
		this.texte = texte;
		this.operation = operation;
		this.style = style;
		this.typeSyntaxe = typeSyntaxe;
	}

	public String getTexte() {
		return texte;
	}

	@Override
	public Class<? extends Operation> getOperation() {
		return operation;
	}

	@Override
	public STYLE getStyle() {
		return style;
	}

	@Override
	public TypeSyntaxe getTypeSyntaxe() {
		return typeSyntaxe;
	}

	@Override
	public MathematiqueOperation[] operations() {
		return values();
	}

}
