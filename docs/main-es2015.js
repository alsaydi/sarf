(self["webpackChunksarf_ui"] = self["webpackChunksarf_ui"] || []).push([["main"],{

/***/ 8255:
/*!*******************************************************!*\
  !*** ./$_lazy_route_resources/ lazy namespace object ***!
  \*******************************************************/
/***/ (function(module) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = 8255;
module.exports = webpackEmptyAsyncContext;

/***/ }),

/***/ 1932:
/*!********************************************************!*\
  !*** ./src/app/active-verbs/active-verbs.component.ts ***!
  \********************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "ActiveVerbsComponent": function() { return /* binding */ ActiveVerbsComponent; }
/* harmony export */ });
/* harmony import */ var _models_Utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/Utils */ 4282);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/tabs */ 9348);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _sarf_verb_pronouns_sarf_verb_pronouns_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../sarf-verb-pronouns/sarf-verb-pronouns.component */ 3157);








function ActiveVerbsComponent_ng_template_2_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_2_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const pastGroup_r13 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", pastGroup_r13.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", pastGroup_r13.verbs);
} }
function ActiveVerbsComponent_ng_template_2_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_2_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r9 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r9.pastGroups);
} }
function ActiveVerbsComponent_ng_template_2_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const pastGroup_r15 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", pastGroup_r15.verbs);
} }
function ActiveVerbsComponent_ng_template_2_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_2_ng_template_3_div_0_Template, 2, 1, "div", 12);
} if (rf & 2) {
    const ctx_r11 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r11.pastGroups);
} }
function ActiveVerbsComponent_ng_template_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_2_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_2_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_2_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r10 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r0.showSubTabs())("ngIfThen", _r8)("ngIfElse", _r10);
} }
function ActiveVerbsComponent_ng_template_4_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_4_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const nominativePresent_r22 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", nominativePresent_r22.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", nominativePresent_r22.verbs);
} }
function ActiveVerbsComponent_ng_template_4_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_4_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r18 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r18.nominativePresentGroups);
} }
function ActiveVerbsComponent_ng_template_4_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 14);
} if (rf & 2) {
    const ctx_r20 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r20.nominativePresentGroups[0].verbs);
} }
function ActiveVerbsComponent_ng_template_4_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_4_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_4_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_4_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r17 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r19 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r1.showSubTabs())("ngIfThen", _r17)("ngIfElse", _r19);
} }
function ActiveVerbsComponent_ng_template_6_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_6_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const accusativePresent_r29 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", accusativePresent_r29.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", accusativePresent_r29.verbs);
} }
function ActiveVerbsComponent_ng_template_6_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_6_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r25 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r25.accusativePresentGroups);
} }
function ActiveVerbsComponent_ng_template_6_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 14);
} if (rf & 2) {
    const ctx_r27 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r27.accusativePresentGroups[0].verbs);
} }
function ActiveVerbsComponent_ng_template_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_6_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_6_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_6_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r24 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r26 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r2.showSubTabs())("ngIfThen", _r24)("ngIfElse", _r26);
} }
function ActiveVerbsComponent_ng_template_8_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_8_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const jussivePresent_r36 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", jussivePresent_r36.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", jussivePresent_r36.verbs);
} }
function ActiveVerbsComponent_ng_template_8_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_8_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r32 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r32.jussivePresentGroups);
} }
function ActiveVerbsComponent_ng_template_8_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 14);
} if (rf & 2) {
    const ctx_r34 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r34.jussivePresentGroups[0].verbs);
} }
function ActiveVerbsComponent_ng_template_8_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_8_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_8_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_8_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r31 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r33 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r3.showSubTabs())("ngIfThen", _r31)("ngIfElse", _r33);
} }
function ActiveVerbsComponent_ng_template_10_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_10_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const emphasizedPresent_r43 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", emphasizedPresent_r43.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", emphasizedPresent_r43.verbs);
} }
function ActiveVerbsComponent_ng_template_10_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_10_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r39 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r39.emphasizedPresentGroups);
} }
function ActiveVerbsComponent_ng_template_10_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 14);
} if (rf & 2) {
    const ctx_r41 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r41.emphasizedPresentGroups[0].verbs);
} }
function ActiveVerbsComponent_ng_template_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_10_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_10_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_10_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r38 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r40 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r4.showSubTabs())("ngIfThen", _r38)("ngIfElse", _r40);
} }
function ActiveVerbsComponent_ng_template_12_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_12_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const imperative_r50 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", imperative_r50.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", imperative_r50.verbs);
} }
function ActiveVerbsComponent_ng_template_12_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_12_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r46 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r46.imperativeGroups);
} }
function ActiveVerbsComponent_ng_template_12_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 14);
} if (rf & 2) {
    const ctx_r48 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r48.imperativeGroups[0].verbs);
} }
function ActiveVerbsComponent_ng_template_12_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_12_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_12_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_12_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r45 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r47 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r5.showSubTabs())("ngIfThen", _r45)("ngIfElse", _r47);
} }
function ActiveVerbsComponent_ng_template_14_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function ActiveVerbsComponent_ng_template_14_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const emphasizedImperative_r57 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", emphasizedImperative_r57.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", emphasizedImperative_r57.verbs);
} }
function ActiveVerbsComponent_ng_template_14_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_14_ng_template_1_div_1_Template, 3, 2, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r53 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r53.emphasizedImperativeGroups);
} }
function ActiveVerbsComponent_ng_template_14_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 14);
} if (rf & 2) {
    const ctx_r55 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r55.emphasizedImperativeGroups[0].verbs);
} }
function ActiveVerbsComponent_ng_template_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, ActiveVerbsComponent_ng_template_14_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, ActiveVerbsComponent_ng_template_14_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, ActiveVerbsComponent_ng_template_14_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r52 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r54 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r6.showSubTabs())("ngIfThen", _r52)("ngIfElse", _r54);
} }
class ActiveVerbsComponent {
    constructor(sarfService, route, appNotificationsService) {
        this.sarfService = sarfService;
        this.route = route;
        this.appNotificationsService = appNotificationsService;
    }
    ngOnInit() {
        const verbSelectionDetail = this.getVerbSelectionDetail();
        this.serviceSubscription = this.sarfService.getActiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
            console.log('active verbs', result);
            this.pastGroups = result.map(r => ({ 'key': r.key, 'verbs': r.past }));
            this.nominativePresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.nominativePresent }));
            this.accusativePresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.accusativePresent }));
            this.jussivePresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.jussivePresent }));
            ;
            this.emphasizedPresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.emphasizedPresent }));
            this.imperativeGroups = result.map(r => ({ 'key': r.key, 'verbs': r.imperative }));
            this.emphasizedImperativeGroups = result.map(r => ({ 'key': r.key, 'verbs': r.emphasizedImperative }));
        });
        this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
    }
    showSubTabs() {
        return this.pastGroups.length > 1;
    }
    getVerbSelectionDetail() {
        return _models_Utils__WEBPACK_IMPORTED_MODULE_0__.Utils.getVerbSelectionDetail(this.route);
    }
    ngOnDestroy() {
        var _a;
        (_a = this.serviceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
    }
}
ActiveVerbsComponent.ɵfac = function ActiveVerbsComponent_Factory(t) { return new (t || ActiveVerbsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_1__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__.AppNotificationsService)); };
ActiveVerbsComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({ type: ActiveVerbsComponent, selectors: [["app-active-verbs"]], decls: 15, vars: 0, consts: [["animationDuration", "0ms", "color", "accent", "backgroundColor", "primary", 1, "tab-group"], ["label", "\u0627\u0644\u0645\u0627\u0636\u064A"], ["matTabContent", ""], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u0631\u0641\u0648\u0639"], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u0646\u0635\u0648\u0628"], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u062C\u0632\u0648\u0645 "], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u0624\u0643\u062F"], ["label", "\u0627\u0644\u0623\u0645\u0631"], ["label", "\u0627\u0644\u0623\u0645\u0631 \u0627\u0644\u0645\u0624\u0643\u062F"], [4, "ngIf", "ngIfThen", "ngIfElse"], ["withSubTabs", ""], ["simpleBlock", ""], [4, "ngFor", "ngForOf"], [3, "label"], [3, "verbs"]], template: function ActiveVerbsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, ActiveVerbsComponent_ng_template_2_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "mat-tab", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](4, ActiveVerbsComponent_ng_template_4_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](5, "mat-tab", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](6, ActiveVerbsComponent_ng_template_6_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "mat-tab", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](8, ActiveVerbsComponent_ng_template_8_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "mat-tab", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](10, ActiveVerbsComponent_ng_template_10_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](11, "mat-tab", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](12, ActiveVerbsComponent_ng_template_12_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](13, "mat-tab", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](14, ActiveVerbsComponent_ng_template_14_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabGroup, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTab, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabContent, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgForOf, _sarf_verb_pronouns_sarf_verb_pronouns_component__WEBPACK_IMPORTED_MODULE_3__.SarfVerbPronounsComponent], styles: [".mat-tab-label-content {\n    font-size: 1.3em;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFjdGl2ZS12ZXJicy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksZ0JBQWdCO0FBQ3BCIiwiZmlsZSI6ImFjdGl2ZS12ZXJicy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC10YWItbGFiZWwtY29udGVudCB7XG4gICAgZm9udC1zaXplOiAxLjNlbTtcbn1cbiJdfQ== */"], encapsulation: 2 });


/***/ }),

/***/ 158:
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "AppRoutingModule": function() { return /* binding */ AppRoutingModule; }
/* harmony export */ });
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);



const routes = [];
class AppRoutingModule {
}
AppRoutingModule.ɵfac = function AppRoutingModule_Factory(t) { return new (t || AppRoutingModule)(); };
AppRoutingModule.ɵmod = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: AppRoutingModule });
AppRoutingModule.ɵinj = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__.RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })], _angular_router__WEBPACK_IMPORTED_MODULE_1__.RouterModule] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__.RouterModule], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__.RouterModule] }); })();


/***/ }),

/***/ 5041:
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "AppComponent": function() { return /* binding */ AppComponent; }
/* harmony export */ });
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../environments/environment */ 2340);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/toolbar */ 4106);
/* harmony import */ var _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/flex-layout/flex */ 582);
/* harmony import */ var _rootsearch_rootsearch_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./rootsearch/rootsearch.component */ 9047);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 1258);






class AppComponent {
    constructor() {
        this.title = 'صرف';
        console.log(_environments_environment__WEBPACK_IMPORTED_MODULE_0__.environment);
    }
}
AppComponent.ɵfac = function AppComponent_Factory(t) { return new (t || AppComponent)(); };
AppComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({ type: AppComponent, selectors: [["app-root"]], decls: 15, vars: 0, consts: [[1, "main-grid"], [1, "right-grid"], [1, "middle-grid"], ["color", "primary"], ["fxLayout", "column"], ["fxFlex", "", 1, "app-name"], ["fxFlex", "", 1, "app-sub-title"], [1, "left-grid"]], template: function AppComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](3, "mat-toolbar", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "mat-toolbar-row", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](5, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](6, "h1");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](7, " \u0635\u0640\u0640\u0640\u0640\u0640\u0640\u0640\u0640\u0640\u0640\u0631\u0641 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](8, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](9, "h2");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](10, " \u0646\u0638\u0627\u0645 \u0627\u0644\u0625\u0634\u062A\u0642\u0627\u0642 \u0648 \u0627\u0644\u062A\u0635\u0631\u064A\u0641 \u0641\u064A \u0627\u0644\u0644\u063A\u0629 \u0627\u0644\u0639\u0631\u0628\u064A\u0629 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](11, "main");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](12, "app-rootsearch");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](13, "router-outlet");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelement"](14, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_toolbar__WEBPACK_IMPORTED_MODULE_3__.MatToolbar, _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_3__.MatToolbarRow, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__.DefaultLayoutDirective, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__.DefaultFlexDirective, _rootsearch_rootsearch_component__WEBPACK_IMPORTED_MODULE_1__.RootsearchComponent, _angular_router__WEBPACK_IMPORTED_MODULE_5__.RouterOutlet], styles: [".main-grid[_ngcontent-%COMP%] {\r\n    display: grid;\r\n    grid-template-columns: 1fr 8fr 1fr;\r\n}\r\n\r\n.app-name[_ngcontent-%COMP%], .app-sub-title[_ngcontent-%COMP%] {\r\n    text-align: center;\r\n    font-size: 1.5em;\r\n    font-family: Kitab, system-ui;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImFwcC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksYUFBYTtJQUNiLGtDQUFrQztBQUN0Qzs7QUFFQTs7SUFFSSxrQkFBa0I7SUFDbEIsZ0JBQWdCO0lBQ2hCLDZCQUE2QjtBQUNqQyIsImZpbGUiOiJhcHAuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5tYWluLWdyaWQge1xyXG4gICAgZGlzcGxheTogZ3JpZDtcclxuICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogMWZyIDhmciAxZnI7XHJcbn1cclxuXHJcbi5hcHAtbmFtZSxcclxuLmFwcC1zdWItdGl0bGUge1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gICAgZm9udC1zaXplOiAxLjVlbTtcclxuICAgIGZvbnQtZmFtaWx5OiBLaXRhYiwgc3lzdGVtLXVpO1xyXG59Il19 */"] });


/***/ }),

/***/ 6747:
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "AppModule": function() { return /* binding */ AppModule; }
/* harmony export */ });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/platform-browser */ 1570);
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/common/http */ 3882);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./app-routing.module */ 158);
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./app.component */ 5041);
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/platform-browser/animations */ 718);
/* harmony import */ var _material_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./material-module */ 8696);
/* harmony import */ var _angular_flex_layout__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/flex-layout */ 8662);
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/forms */ 1707);
/* harmony import */ var _rootsearch_rootsearch_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./rootsearch/rootsearch.component */ 9047);
/* harmony import */ var _conjugation_label_conjugation_label_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./conjugation-label/conjugation-label.component */ 5124);
/* harmony import */ var _conjugation_group_conjugation_group_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./conjugation-group/conjugation-group.component */ 40);
/* harmony import */ var _trilateral_conjugation_panel_trilateral_conjugation_panel_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./trilateral-conjugation-panel/trilateral-conjugation-panel.component */ 3932);
/* harmony import */ var _quadilateral_conjugation_panel_quadilateral_conjugation_panel_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./quadilateral-conjugation-panel/quadilateral-conjugation-panel.component */ 2482);
/* harmony import */ var _start_start_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./start/start.component */ 5246);
/* harmony import */ var _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./not-found/not-found.component */ 1142);
/* harmony import */ var _initial_sarf_initial_sarf_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./initial-sarf/initial-sarf.component */ 9197);
/* harmony import */ var _active_verbs_active_verbs_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./active-verbs/active-verbs.component */ 1932);
/* harmony import */ var _sarf_verb_pronouns_sarf_verb_pronouns_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./sarf-verb-pronouns/sarf-verb-pronouns.component */ 3157);
/* harmony import */ var _passive_verbs_passive_verbs_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./passive-verbs/passive-verbs.component */ 804);
/* harmony import */ var _derived_nouns_derived_nouns_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./derived-nouns/derived-nouns.component */ 3931);
/* harmony import */ var _nouns_listing_nouns_listing_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./nouns-listing/nouns-listing.component */ 1413);
/* harmony import */ var _gerunds_gerunds_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./gerunds/gerunds.component */ 5809);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/core */ 2316);

























const appRoutes = [
    { path: '', component: _start_start_component__WEBPACK_IMPORTED_MODULE_8__.StartComponent },
    { path: 'tri/:root', component: _trilateral_conjugation_panel_trilateral_conjugation_panel_component__WEBPACK_IMPORTED_MODULE_6__.TrilateralConjugationPanelComponent },
    { path: 'quad/:root', component: _quadilateral_conjugation_panel_quadilateral_conjugation_panel_component__WEBPACK_IMPORTED_MODULE_7__.QuadilateralConjugationPanelComponent },
    { path: 'verb/tri/u/:verb/:class', component: _initial_sarf_initial_sarf_component__WEBPACK_IMPORTED_MODULE_10__.InitialSarfComponent },
    { path: 'verb/tri/u/:verb/:class/active', component: _active_verbs_active_verbs_component__WEBPACK_IMPORTED_MODULE_11__.ActiveVerbsComponent },
    { path: 'verb/tri/u/:verb/:class/passive', component: _passive_verbs_passive_verbs_component__WEBPACK_IMPORTED_MODULE_13__.PassiveVerbsComponent },
    { path: 'verb/tri/u/:verb/:class/nouns', component: _derived_nouns_derived_nouns_component__WEBPACK_IMPORTED_MODULE_14__.DerivedNounsComponent },
    { path: 'verb/tri/u/:verb/:class/gerunds', component: _gerunds_gerunds_component__WEBPACK_IMPORTED_MODULE_16__.GerundsComponent },
    { path: 'verb/tri/a/:verb/:formula', component: _initial_sarf_initial_sarf_component__WEBPACK_IMPORTED_MODULE_10__.InitialSarfComponent },
    { path: 'verb/tri/a/:verb/:formula/active', component: _active_verbs_active_verbs_component__WEBPACK_IMPORTED_MODULE_11__.ActiveVerbsComponent },
    { path: 'verb/tri/a/:verb/:formula/passive', component: _passive_verbs_passive_verbs_component__WEBPACK_IMPORTED_MODULE_13__.PassiveVerbsComponent },
    { path: 'verb/tri/a/:verb/:formula/nouns', component: _derived_nouns_derived_nouns_component__WEBPACK_IMPORTED_MODULE_14__.DerivedNounsComponent },
    { path: 'verb/tri/a/:verb/:formula/gerunds', component: _gerunds_gerunds_component__WEBPACK_IMPORTED_MODULE_16__.GerundsComponent },
    { path: 'verb/quad/u/:verb', component: _initial_sarf_initial_sarf_component__WEBPACK_IMPORTED_MODULE_10__.InitialSarfComponent },
    { path: 'verb/quad/u/:verb/active', component: _active_verbs_active_verbs_component__WEBPACK_IMPORTED_MODULE_11__.ActiveVerbsComponent },
    { path: 'verb/quad/u/:verb/passive', component: _passive_verbs_passive_verbs_component__WEBPACK_IMPORTED_MODULE_13__.PassiveVerbsComponent },
    { path: 'verb/quad/u/:verb/nouns', component: _derived_nouns_derived_nouns_component__WEBPACK_IMPORTED_MODULE_14__.DerivedNounsComponent },
    { path: 'verb/quad/u/:verb/gerunds', component: _gerunds_gerunds_component__WEBPACK_IMPORTED_MODULE_16__.GerundsComponent },
    { path: 'verb/quad/a/:verb/:formula', component: _initial_sarf_initial_sarf_component__WEBPACK_IMPORTED_MODULE_10__.InitialSarfComponent },
    { path: 'verb/quad/a/:verb/:formula/active', component: _active_verbs_active_verbs_component__WEBPACK_IMPORTED_MODULE_11__.ActiveVerbsComponent },
    { path: 'verb/quad/a/:verb/:formula/passive', component: _passive_verbs_passive_verbs_component__WEBPACK_IMPORTED_MODULE_13__.PassiveVerbsComponent },
    { path: 'verb/quad/a/:verb/:formula/nouns', component: _derived_nouns_derived_nouns_component__WEBPACK_IMPORTED_MODULE_14__.DerivedNounsComponent },
    { path: 'verb/quad/a/:verb/:formula/gerunds', component: _gerunds_gerunds_component__WEBPACK_IMPORTED_MODULE_16__.GerundsComponent },
];
class AppModule {
}
AppModule.ɵfac = function AppModule_Factory(t) { return new (t || AppModule)(); };
AppModule.ɵmod = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_17__["ɵɵdefineNgModule"]({ type: AppModule, bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_1__.AppComponent] });
AppModule.ɵinj = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_17__["ɵɵdefineInjector"]({ providers: [], imports: [[
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_18__.BrowserModule,
            _angular_forms__WEBPACK_IMPORTED_MODULE_19__.FormsModule,
            _angular_forms__WEBPACK_IMPORTED_MODULE_19__.ReactiveFormsModule,
            _app_routing_module__WEBPACK_IMPORTED_MODULE_0__.AppRoutingModule,
            _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_20__.BrowserAnimationsModule,
            _material_module__WEBPACK_IMPORTED_MODULE_2__.AppMaterialModule,
            _angular_flex_layout__WEBPACK_IMPORTED_MODULE_21__.FlexLayoutModule,
            _angular_common_http__WEBPACK_IMPORTED_MODULE_22__.HttpClientModule,
            _angular_router__WEBPACK_IMPORTED_MODULE_23__.RouterModule.forRoot(appRoutes, { onSameUrlNavigation: 'reload' })
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_17__["ɵɵsetNgModuleScope"](AppModule, { declarations: [_app_component__WEBPACK_IMPORTED_MODULE_1__.AppComponent,
        _rootsearch_rootsearch_component__WEBPACK_IMPORTED_MODULE_3__.RootsearchComponent,
        _conjugation_label_conjugation_label_component__WEBPACK_IMPORTED_MODULE_4__.ConjugationLabelComponent,
        _conjugation_group_conjugation_group_component__WEBPACK_IMPORTED_MODULE_5__.ConjugationGroupComponent,
        _trilateral_conjugation_panel_trilateral_conjugation_panel_component__WEBPACK_IMPORTED_MODULE_6__.TrilateralConjugationPanelComponent,
        _quadilateral_conjugation_panel_quadilateral_conjugation_panel_component__WEBPACK_IMPORTED_MODULE_7__.QuadilateralConjugationPanelComponent,
        _start_start_component__WEBPACK_IMPORTED_MODULE_8__.StartComponent,
        _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_9__.NotFoundComponent,
        _initial_sarf_initial_sarf_component__WEBPACK_IMPORTED_MODULE_10__.InitialSarfComponent,
        _active_verbs_active_verbs_component__WEBPACK_IMPORTED_MODULE_11__.ActiveVerbsComponent,
        _sarf_verb_pronouns_sarf_verb_pronouns_component__WEBPACK_IMPORTED_MODULE_12__.SarfVerbPronounsComponent,
        _passive_verbs_passive_verbs_component__WEBPACK_IMPORTED_MODULE_13__.PassiveVerbsComponent,
        _derived_nouns_derived_nouns_component__WEBPACK_IMPORTED_MODULE_14__.DerivedNounsComponent,
        _nouns_listing_nouns_listing_component__WEBPACK_IMPORTED_MODULE_15__.NounsListingComponent,
        _gerunds_gerunds_component__WEBPACK_IMPORTED_MODULE_16__.GerundsComponent], imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_18__.BrowserModule,
        _angular_forms__WEBPACK_IMPORTED_MODULE_19__.FormsModule,
        _angular_forms__WEBPACK_IMPORTED_MODULE_19__.ReactiveFormsModule,
        _app_routing_module__WEBPACK_IMPORTED_MODULE_0__.AppRoutingModule,
        _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_20__.BrowserAnimationsModule,
        _material_module__WEBPACK_IMPORTED_MODULE_2__.AppMaterialModule,
        _angular_flex_layout__WEBPACK_IMPORTED_MODULE_21__.FlexLayoutModule,
        _angular_common_http__WEBPACK_IMPORTED_MODULE_22__.HttpClientModule, _angular_router__WEBPACK_IMPORTED_MODULE_23__.RouterModule] }); })();


/***/ }),

/***/ 40:
/*!******************************************************************!*\
  !*** ./src/app/conjugation-group/conjugation-group.component.ts ***!
  \******************************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "ConjugationGroupComponent": function() { return /* binding */ ConjugationGroupComponent; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/card */ 2118);
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material/grid-list */ 5937);
/* harmony import */ var _conjugation_label_conjugation_label_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../conjugation-label/conjugation-label.component */ 5124);





function ConjugationGroupComponent_div_0_mat_grid_tile_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "mat-grid-tile");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelement"](1, "app-conjugation-label", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
} if (rf & 2) {
    const conjugationClass_r2 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("conjugationClass", conjugationClass_r2);
} }
function ConjugationGroupComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](1, "mat-card");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](2, "mat-card-title");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](4, "mat-card-content");
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementStart"](5, "mat-grid-list", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](6, ConjugationGroupComponent_div_0_mat_grid_tile_6_Template, 2, 1, "mat-grid-tile", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtextInterpolate"](ctx_r0.conjugationGroup.label);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵpropertyInterpolate"]("cols", ctx_r0.conjugationGroup.conjugationClasses.length);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngForOf", ctx_r0.conjugationGroup.conjugationClasses);
} }
class ConjugationGroupComponent {
    constructor() { }
    ngOnInit() {
    }
}
ConjugationGroupComponent.ɵfac = function ConjugationGroupComponent_Factory(t) { return new (t || ConjugationGroupComponent)(); };
ConjugationGroupComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineComponent"]({ type: ConjugationGroupComponent, selectors: [["app-conjugation-group"]], inputs: { conjugationGroup: "conjugationGroup" }, decls: 1, vars: 1, consts: [[4, "ngIf"], ["rowHeight", "fit", 3, "cols"], [4, "ngFor", "ngForOf"], [3, "conjugationClass"]], template: function ConjugationGroupComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵtemplate"](0, ConjugationGroupComponent_div_0_Template, 7, 3, "div", 0);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵproperty"]("ngIf", ctx.conjugationGroup);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__.NgIf, _angular_material_card__WEBPACK_IMPORTED_MODULE_3__.MatCard, _angular_material_card__WEBPACK_IMPORTED_MODULE_3__.MatCardTitle, _angular_material_card__WEBPACK_IMPORTED_MODULE_3__.MatCardContent, _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_4__.MatGridList, _angular_common__WEBPACK_IMPORTED_MODULE_2__.NgForOf, _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_4__.MatGridTile, _conjugation_label_conjugation_label_component__WEBPACK_IMPORTED_MODULE_0__.ConjugationLabelComponent], styles: ["mat-grid-tile[_ngcontent-%COMP%] {\r\n    background: lightblue;    \r\n  }\r\n  mat-card-title[_ngcontent-%COMP%] {\r\n      font-size: large;\r\n  }\r\n  mat-grid-list[_ngcontent-%COMP%] {\r\n      height: 100px;\r\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImNvbmp1Z2F0aW9uLWdyb3VwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxxQkFBcUI7RUFDdkI7RUFDQTtNQUNJLGdCQUFnQjtFQUNwQjtFQUVBO01BQ0ksYUFBYTtFQUNqQiIsImZpbGUiOiJjb25qdWdhdGlvbi1ncm91cC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsibWF0LWdyaWQtdGlsZSB7XHJcbiAgICBiYWNrZ3JvdW5kOiBsaWdodGJsdWU7ICAgIFxyXG4gIH1cclxuICBtYXQtY2FyZC10aXRsZSB7XHJcbiAgICAgIGZvbnQtc2l6ZTogbGFyZ2U7XHJcbiAgfVxyXG5cclxuICBtYXQtZ3JpZC1saXN0IHtcclxuICAgICAgaGVpZ2h0OiAxMDBweDtcclxuICB9Il19 */"] });


/***/ }),

/***/ 5124:
/*!******************************************************************!*\
  !*** ./src/app/conjugation-label/conjugation-label.component.ts ***!
  \******************************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "ConjugationLabelComponent": function() { return /* binding */ ConjugationLabelComponent; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/grid-list */ 5937);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ 1258);



class ConjugationLabelComponent {
    constructor() { }
    ngOnInit() {
    }
    showDetails(event) {
        console.log(event);
    }
}
ConjugationLabelComponent.ɵfac = function ConjugationLabelComponent_Factory(t) { return new (t || ConjugationLabelComponent)(); };
ConjugationLabelComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ConjugationLabelComponent, selectors: [["app-conjugation-label"]], inputs: { conjugationClass: "conjugationClass" }, decls: 6, vars: 3, consts: [[1, "verb-link", 3, "routerLink"]], template: function ConjugationLabelComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "mat-grid-tile-header");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "p");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "mat-grid-tile-footer");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "a", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.conjugationClass.label);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("routerLink", ctx.conjugationClass.reference);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", ctx.conjugationClass.content, " ");
    } }, directives: [_angular_material_grid_list__WEBPACK_IMPORTED_MODULE_1__.MatGridTileText, _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_1__.MatGridTileHeaderCssMatStyler, _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_1__.MatGridTileFooterCssMatStyler, _angular_router__WEBPACK_IMPORTED_MODULE_2__.RouterLinkWithHref], styles: [".mat-grid-tile-header[_ngcontent-%COMP%]{\r\n    background-color: rgb(169, 168, 168) !important;\r\n    max-height: 35%;\r\n    font-size: large;\r\n    color: black !important;\r\n}\r\n\r\n.mat-grid-tile-footer[_ngcontent-%COMP%]{\r\n    font-size: x-large;\r\n    min-height: 65%;\r\n    background-color: rgb(185, 202, 202) !important;\r\n}\r\n\r\n.verb-link[_ngcontent-%COMP%] {\r\n  text-decoration: none;\r\n  color: rgb(8, 90, 153);\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImNvbmp1Z2F0aW9uLWxhYmVsLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtFQUNFO0lBQ0UsK0NBQStDO0lBQy9DLGVBQWU7SUFDZixnQkFBZ0I7SUFDaEIsdUJBQXVCO0FBQzNCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLGVBQWU7SUFDZiwrQ0FBK0M7QUFDbkQ7O0FBRUE7RUFDRSxxQkFBcUI7RUFDckIsc0JBQXNCO0FBQ3hCIiwiZmlsZSI6ImNvbmp1Z2F0aW9uLWxhYmVsLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuICAubWF0LWdyaWQtdGlsZS1oZWFkZXJ7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiByZ2IoMTY5LCAxNjgsIDE2OCkgIWltcG9ydGFudDtcclxuICAgIG1heC1oZWlnaHQ6IDM1JTtcclxuICAgIGZvbnQtc2l6ZTogbGFyZ2U7XHJcbiAgICBjb2xvcjogYmxhY2sgIWltcG9ydGFudDtcclxufVxyXG5cclxuLm1hdC1ncmlkLXRpbGUtZm9vdGVye1xyXG4gICAgZm9udC1zaXplOiB4LWxhcmdlO1xyXG4gICAgbWluLWhlaWdodDogNjUlO1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogcmdiKDE4NSwgMjAyLCAyMDIpICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcbi52ZXJiLWxpbmsge1xyXG4gIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcclxuICBjb2xvcjogcmdiKDgsIDkwLCAxNTMpO1xyXG59Il19 */"] });


/***/ }),

/***/ 3931:
/*!**********************************************************!*\
  !*** ./src/app/derived-nouns/derived-nouns.component.ts ***!
  \**********************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "DerivedNounsComponent": function() { return /* binding */ DerivedNounsComponent; }
/* harmony export */ });
/* harmony import */ var _models_Utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/Utils */ 4282);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/tabs */ 9348);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _nouns_listing_nouns_listing_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../nouns-listing/nouns-listing.component */ 1413);








function DerivedNounsComponent_ng_template_2_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function DerivedNounsComponent_ng_template_2_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const activeParticiple_r13 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", activeParticiple_r13.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", activeParticiple_r13.indefiniteNouns)("annexedNouns", activeParticiple_r13.annexedNouns)("definiteNouns", activeParticiple_r13.definiteNouns);
} }
function DerivedNounsComponent_ng_template_2_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_ng_template_2_ng_template_1_div_1_Template, 3, 4, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r9 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r9.activeParticiples);
} }
function DerivedNounsComponent_ng_template_2_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const activeParticiple_r15 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", activeParticiple_r15.indefiniteNouns)("annexedNouns", activeParticiple_r15.annexedNouns)("definiteNouns", activeParticiple_r15.definiteNouns);
} }
function DerivedNounsComponent_ng_template_2_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, DerivedNounsComponent_ng_template_2_ng_template_3_div_0_Template, 2, 3, "div", 12);
} if (rf & 2) {
    const ctx_r11 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r11.activeParticiples);
} }
function DerivedNounsComponent_ng_template_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, DerivedNounsComponent_ng_template_2_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_ng_template_2_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, DerivedNounsComponent_ng_template_2_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r10 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r0.showSubTabs())("ngIfThen", _r8)("ngIfElse", _r10);
} }
function DerivedNounsComponent_ng_template_4_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function DerivedNounsComponent_ng_template_4_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const passiveParticiple_r22 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", passiveParticiple_r22.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", passiveParticiple_r22.indefiniteNouns)("annexedNouns", passiveParticiple_r22.annexedNouns)("definiteNouns", passiveParticiple_r22.definiteNouns);
} }
function DerivedNounsComponent_ng_template_4_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_ng_template_4_ng_template_1_div_1_Template, 3, 4, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r18 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r18.passiveParticiples);
} }
function DerivedNounsComponent_ng_template_4_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const passiveParticiple_r24 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", passiveParticiple_r24.indefiniteNouns)("annexedNouns", passiveParticiple_r24.annexedNouns)("definiteNouns", passiveParticiple_r24.definiteNouns);
} }
function DerivedNounsComponent_ng_template_4_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, DerivedNounsComponent_ng_template_4_ng_template_3_div_0_Template, 2, 3, "div", 12);
} if (rf & 2) {
    const ctx_r20 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r20.passiveParticiples);
} }
function DerivedNounsComponent_ng_template_4_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, DerivedNounsComponent_ng_template_4_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_ng_template_4_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, DerivedNounsComponent_ng_template_4_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r17 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r19 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r1.showSubTabs())("ngIfThen", _r17)("ngIfElse", _r19);
} }
function DerivedNounsComponent_mat_tab_5_ng_template_1_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const timeAndPlaceNoun_r32 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", timeAndPlaceNoun_r32.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", timeAndPlaceNoun_r32.indefiniteNouns)("annexedNouns", timeAndPlaceNoun_r32.annexedNouns)("definiteNouns", timeAndPlaceNoun_r32.definiteNouns);
} }
function DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_1_div_1_Template, 3, 4, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r28 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r28.timeAndPlaceNouns);
} }
function DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const timeAndPlaceNoun_r34 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", timeAndPlaceNoun_r34.indefiniteNouns)("annexedNouns", timeAndPlaceNoun_r34.annexedNouns)("definiteNouns", timeAndPlaceNoun_r34.definiteNouns);
} }
function DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_3_div_0_Template, 2, 3, "div", 12);
} if (rf & 2) {
    const ctx_r30 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r30.timeAndPlaceNouns);
} }
function DerivedNounsComponent_mat_tab_5_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, DerivedNounsComponent_mat_tab_5_ng_template_1_div_0_Template, 1, 0, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_1_Template, 2, 1, "ng-template", null, 10, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, DerivedNounsComponent_mat_tab_5_ng_template_1_ng_template_3_Template, 1, 1, "ng-template", null, 11, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r27 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r29 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r25 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r25.showSubTabs())("ngIfThen", _r27)("ngIfElse", _r29);
} }
function DerivedNounsComponent_mat_tab_5_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, DerivedNounsComponent_mat_tab_5_ng_template_1_Template, 5, 3, "ng-template", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} }
function DerivedNounsComponent_mat_tab_6_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const exaggeratedActiveParticiple_r36 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", exaggeratedActiveParticiple_r36.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", exaggeratedActiveParticiple_r36.indefiniteNouns)("annexedNouns", exaggeratedActiveParticiple_r36.annexedNouns)("definiteNouns", exaggeratedActiveParticiple_r36.definiteNouns);
} }
function DerivedNounsComponent_mat_tab_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, DerivedNounsComponent_mat_tab_6_div_2_Template, 3, 4, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r3.exaggeratedActiveParticiples);
} }
function DerivedNounsComponent_mat_tab_7_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const instrumentalNoun_r38 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", instrumentalNoun_r38.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", instrumentalNoun_r38.indefiniteNouns)("annexedNouns", instrumentalNoun_r38.annexedNouns)("definiteNouns", instrumentalNoun_r38.definiteNouns);
} }
function DerivedNounsComponent_mat_tab_7_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, DerivedNounsComponent_mat_tab_7_div_2_Template, 3, 4, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r4.instrumentalNouns);
} }
function DerivedNounsComponent_mat_tab_8_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const elative_r40 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", elative_r40.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("annexedToIndefinite", elative_r40.annexedToIndefinite)("annexedToDefinite", elative_r40.annexedToDefinite)("indefiniteNouns", elative_r40.indefiniteNouns)("definiteNouns", elative_r40.definiteNouns);
} }
function DerivedNounsComponent_mat_tab_8_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, DerivedNounsComponent_mat_tab_8_div_2_Template, 3, 5, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r5 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r5.elatives);
} }
function DerivedNounsComponent_mat_tab_9_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const assimilate_r42 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", assimilate_r42.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", assimilate_r42.indefiniteNouns)("annexedNouns", assimilate_r42.annexedNouns)("definiteNouns", assimilate_r42.definiteNouns);
} }
function DerivedNounsComponent_mat_tab_9_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, DerivedNounsComponent_mat_tab_9_div_2_Template, 3, 4, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r6.assimilates);
} }
class DerivedNounsComponent {
    constructor(sarfService, route, appNotificationsService) {
        this.sarfService = sarfService;
        this.route = route;
        this.appNotificationsService = appNotificationsService;
    }
    ngOnInit() {
        const verbSelectionDetail = this.getVerbSelectionDetail();
        this.isUnaugmentedTri = verbSelectionDetail.isTri && !verbSelectionDetail.isAugmented;
        this.serviceSubscription = this.sarfService.getDerivedNouns(verbSelectionDetail).subscribe(result => {
            console.log(result);
            this.activeParticiples = result.activeParticiples;
            this.passiveParticiples = result.passiveParticiples;
            this.timeAndPlaceNouns = result.timeAndPlaceNouns;
            this.exaggeratedActiveParticiples = result.exaggeratedActiveParticiples;
            this.instrumentalNouns = result.instrumentalNouns;
            this.elatives = result.elatives;
            this.assimilates = result.assimilates;
        });
        this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
    }
    showSubTabs() {
        var _a, _b, _c;
        return this.isUnaugmentedTri
            || [(_a = this.activeParticiples) === null || _a === void 0 ? void 0 : _a.length, (_b = this.passiveParticiples) === null || _b === void 0 ? void 0 : _b.length, (_c = this.timeAndPlaceNouns) === null || _c === void 0 ? void 0 : _c.length].reduce((a, b) => a + b) > 3; /* one of these nouns has two or more variations */
    }
    getVerbSelectionDetail() {
        return _models_Utils__WEBPACK_IMPORTED_MODULE_0__.Utils.getVerbSelectionDetail(this.route);
    }
    ngOnDestroy() {
        var _a;
        (_a = this.serviceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
    }
}
DerivedNounsComponent.ɵfac = function DerivedNounsComponent_Factory(t) { return new (t || DerivedNounsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_1__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__.AppNotificationsService)); };
DerivedNounsComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({ type: DerivedNounsComponent, selectors: [["app-derived-nouns"]], decls: 10, vars: 5, consts: [["animationDuration", "0ms", "color", "accent", "backgroundColor", "primary", 1, "tab-group"], ["label", "\u0625\u0633\u0645 \u0627\u0644\u0641\u0627\u0639\u0644"], ["matTabContent", ""], ["label", "\u0625\u0633\u0645 \u0627\u0644\u0645\u0641\u0639\u0648\u0644"], ["label", "\u0625\u0633\u0645\u0627 \u0627\u0644\u0632\u0645\u0627\u0646 \u0648 \u0627\u0644\u0645\u0643\u0627\u0646", 4, "ngIf"], ["label", "\u0645\u0628\u0627\u0644\u063A\u0629 \u0627\u0633\u0645 \u0627\u0644\u0641\u0627\u0639\u0644", 4, "ngIf"], ["label", "\u0627\u0633\u0645 \u0627\u0644\u0622\u0644\u0629", 4, "ngIf"], ["label", "\u0627\u0633\u0645 \u0627\u0644\u062A\u0641\u0636\u064A\u0644", 4, "ngIf"], ["label", "\u0627\u0644\u0635\u0641\u0629 \u0627\u0644\u0645\u0634\u0628\u0647\u0629", 4, "ngIf"], [4, "ngIf", "ngIfThen", "ngIfElse"], ["unaugmentedTriBlock", ""], ["simpleBlock", ""], [4, "ngFor", "ngForOf"], [3, "label"], [3, "indefiniteNouns", "annexedNouns", "definiteNouns"], ["label", "\u0625\u0633\u0645\u0627 \u0627\u0644\u0632\u0645\u0627\u0646 \u0648 \u0627\u0644\u0645\u0643\u0627\u0646"], ["label", "\u0645\u0628\u0627\u0644\u063A\u0629 \u0627\u0633\u0645 \u0627\u0644\u0641\u0627\u0639\u0644"], ["label", "\u0627\u0633\u0645 \u0627\u0644\u0622\u0644\u0629"], ["label", "\u0627\u0633\u0645 \u0627\u0644\u062A\u0641\u0636\u064A\u0644"], ["isElative", "true", 3, "annexedToIndefinite", "annexedToDefinite", "indefiniteNouns", "definiteNouns"], ["label", "\u0627\u0644\u0635\u0641\u0629 \u0627\u0644\u0645\u0634\u0628\u0647\u0629"]], template: function DerivedNounsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, DerivedNounsComponent_ng_template_2_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "mat-tab", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](4, DerivedNounsComponent_ng_template_4_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](5, DerivedNounsComponent_mat_tab_5_Template, 2, 0, "mat-tab", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](6, DerivedNounsComponent_mat_tab_6_Template, 3, 1, "mat-tab", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](7, DerivedNounsComponent_mat_tab_7_Template, 3, 1, "mat-tab", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](8, DerivedNounsComponent_mat_tab_8_Template, 3, 1, "mat-tab", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](9, DerivedNounsComponent_mat_tab_9_Template, 3, 1, "mat-tab", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.timeAndPlaceNouns && ctx.timeAndPlaceNouns.length > 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.exaggeratedActiveParticiples && ctx.exaggeratedActiveParticiples.length > 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.instrumentalNouns && ctx.instrumentalNouns.length > 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.elatives && ctx.elatives.length > 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.assimilates && ctx.assimilates.length > 0);
    } }, directives: [_angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabGroup, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTab, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabContent, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgForOf, _nouns_listing_nouns_listing_component__WEBPACK_IMPORTED_MODULE_3__.NounsListingComponent], styles: [".mat-tab-label[_ngcontent-%COMP%], .mat-tab-label-content[_ngcontent-%COMP%] {\n    font-size: 1.13em;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImRlcml2ZWQtbm91bnMuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTs7SUFFSSxpQkFBaUI7QUFDckIiLCJmaWxlIjoiZGVyaXZlZC1ub3Vucy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1hdC10YWItbGFiZWwsXG4ubWF0LXRhYi1sYWJlbC1jb250ZW50IHtcbiAgICBmb250LXNpemU6IDEuMTNlbTtcbn0iXX0= */"] });


/***/ }),

/***/ 5809:
/*!**********************************************!*\
  !*** ./src/app/gerunds/gerunds.component.ts ***!
  \**********************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "GerundsComponent": function() { return /* binding */ GerundsComponent; }
/* harmony export */ });
/* harmony import */ var _models_Utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/Utils */ 4282);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/tabs */ 9348);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _nouns_listing_nouns_listing_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../nouns-listing/nouns-listing.component */ 1413);








function GerundsComponent_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function GerundsComponent_ng_template_3_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const standard_r10 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", standard_r10.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", standard_r10.indefiniteNouns)("annexedNouns", standard_r10.annexedNouns)("definiteNouns", standard_r10.definiteNouns);
} }
function GerundsComponent_ng_template_3_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_ng_template_3_ng_template_1_div_1_Template, 3, 4, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r6.standards);
} }
function GerundsComponent_ng_template_3_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const standard_r12 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", standard_r12.indefiniteNouns)("annexedNouns", standard_r12.annexedNouns)("definiteNouns", standard_r12.definiteNouns);
} }
function GerundsComponent_ng_template_3_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, GerundsComponent_ng_template_3_ng_template_3_div_0_Template, 2, 3, "div", 9);
} if (rf & 2) {
    const ctx_r8 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r8.standards);
} }
function GerundsComponent_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, GerundsComponent_ng_template_3_div_0_Template, 1, 0, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_ng_template_3_ng_template_1_Template, 2, 1, "ng-template", null, 7, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, GerundsComponent_ng_template_3_ng_template_3_Template, 1, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r5 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r7 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r0.showSubTabs())("ngIfThen", _r5)("ngIfElse", _r7);
} }
function GerundsComponent_ng_template_5_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function GerundsComponent_ng_template_5_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const meem_r19 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", meem_r19.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", meem_r19.indefiniteNouns)("annexedNouns", meem_r19.annexedNouns)("definiteNouns", meem_r19.definiteNouns);
} }
function GerundsComponent_ng_template_5_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_ng_template_5_ng_template_1_div_1_Template, 3, 4, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r15 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r15.meems);
} }
function GerundsComponent_ng_template_5_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const meem_r21 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", meem_r21.indefiniteNouns)("annexedNouns", meem_r21.annexedNouns)("definiteNouns", meem_r21.definiteNouns);
} }
function GerundsComponent_ng_template_5_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, GerundsComponent_ng_template_5_ng_template_3_div_0_Template, 2, 3, "div", 9);
} if (rf & 2) {
    const ctx_r17 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r17.meems);
} }
function GerundsComponent_ng_template_5_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, GerundsComponent_ng_template_5_div_0_Template, 1, 0, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_ng_template_5_ng_template_1_Template, 2, 1, "ng-template", null, 7, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, GerundsComponent_ng_template_5_ng_template_3_Template, 1, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r14 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r16 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r1.showSubTabs())("ngIfThen", _r14)("ngIfElse", _r16);
} }
function GerundsComponent_mat_tab_6_ng_template_1_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function GerundsComponent_mat_tab_6_ng_template_1_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const nomen_r29 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", nomen_r29.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", nomen_r29.indefiniteNouns)("annexedNouns", nomen_r29.annexedNouns)("definiteNouns", nomen_r29.definiteNouns);
} }
function GerundsComponent_mat_tab_6_ng_template_1_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_mat_tab_6_ng_template_1_ng_template_1_div_1_Template, 3, 4, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r25 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r25.nomens);
} }
function GerundsComponent_mat_tab_6_ng_template_1_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const nomen_r31 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", nomen_r31.indefiniteNouns)("annexedNouns", nomen_r31.annexedNouns)("definiteNouns", nomen_r31.definiteNouns);
} }
function GerundsComponent_mat_tab_6_ng_template_1_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, GerundsComponent_mat_tab_6_ng_template_1_ng_template_3_div_0_Template, 2, 3, "div", 9);
} if (rf & 2) {
    const ctx_r27 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r27.nomens);
} }
function GerundsComponent_mat_tab_6_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, GerundsComponent_mat_tab_6_ng_template_1_div_0_Template, 1, 0, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_mat_tab_6_ng_template_1_ng_template_1_Template, 2, 1, "ng-template", null, 7, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, GerundsComponent_mat_tab_6_ng_template_1_ng_template_3_Template, 1, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r24 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r26 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r22 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r22.showSubTabs())("ngIfThen", _r24)("ngIfElse", _r26);
} }
function GerundsComponent_mat_tab_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, GerundsComponent_mat_tab_6_ng_template_1_Template, 5, 3, "ng-template", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} }
function GerundsComponent_mat_tab_7_div_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-nouns-listing", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const qualityGerund_r33 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", qualityGerund_r33.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("indefiniteNouns", qualityGerund_r33.indefiniteNouns)("annexedNouns", qualityGerund_r33.annexedNouns)("definiteNouns", qualityGerund_r33.definiteNouns);
} }
function GerundsComponent_mat_tab_7_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, GerundsComponent_mat_tab_7_div_2_Template, 3, 4, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r3.qualityGerunds);
} }
class GerundsComponent {
    constructor(sarfService, route, appNotificationsService) {
        this.sarfService = sarfService;
        this.route = route;
        this.appNotificationsService = appNotificationsService;
    }
    ngOnInit() {
        const verbSelectionDetail = this.getVerbSelectionDetail();
        this.isUnaugmentedTri = verbSelectionDetail.isTri && !verbSelectionDetail.isAugmented;
        this.serviceSubscription = this.sarfService.getGerunds(verbSelectionDetail).subscribe(result => {
            console.log(result);
            this.standards = result.standards;
            this.meems = result.meems;
            this.nomens = result.nomens;
            this.qualityGerunds = result.qualityGerunds;
        });
        this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
    }
    getVerbSelectionDetail() {
        return _models_Utils__WEBPACK_IMPORTED_MODULE_0__.Utils.getVerbSelectionDetail(this.route);
    }
    showSubTabs() {
        var _a, _b, _c;
        return this.isUnaugmentedTri
            || [(_a = this.standards) === null || _a === void 0 ? void 0 : _a.length, (_b = this.meems) === null || _b === void 0 ? void 0 : _b.length, (_c = this.nomens) === null || _c === void 0 ? void 0 : _c.length].reduce((a, b) => a + b) > 3; /* one of these nouns has two or more variations */
    }
    ngOnDestroy() {
        var _a;
        (_a = this.serviceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
    }
}
GerundsComponent.ɵfac = function GerundsComponent_Factory(t) { return new (t || GerundsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_1__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__.AppNotificationsService)); };
GerundsComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({ type: GerundsComponent, selectors: [["app-gerunds"]], decls: 8, vars: 2, consts: [["animationDuration", "0ms", "color", "accent", "backgroundColor", "primary", 1, "tab-group"], ["label", "\u0627\u0644\u0645\u0635\u062F\u0631 \u0627\u0644\u0623\u0635\u0644\u064A"], ["matTabContent", ""], ["label", "\u0627\u0644\u0645\u0635\u062F\u0631 \u0627\u0644\u0645\u064A\u0645\u064A"], ["label", "\u0645\u0635\u062F\u0631 \u0627\u0644\u0645\u0631\u0629", 4, "ngIf"], ["label", "\u0645\u0635\u062F\u0631 \u0627\u0644\u0647\u064A\u0626\u0629", 4, "ngIf"], [4, "ngIf", "ngIfThen", "ngIfElse"], ["withSubTabs", ""], ["simpleBlock", ""], [4, "ngFor", "ngForOf"], [3, "label"], [3, "indefiniteNouns", "annexedNouns", "definiteNouns"], ["label", "\u0645\u0635\u062F\u0631 \u0627\u0644\u0645\u0631\u0629"], ["label", "\u0645\u0635\u062F\u0631 \u0627\u0644\u0647\u064A\u0626\u0629"]], template: function GerundsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](2, "mat-tab-group", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, GerundsComponent_ng_template_3_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](4, "mat-tab", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](5, GerundsComponent_ng_template_5_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](6, GerundsComponent_mat_tab_6_Template, 2, 0, "mat-tab", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](7, GerundsComponent_mat_tab_7_Template, 3, 1, "mat-tab", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.nomens && ctx.nomens.length > 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx.qualityGerunds && ctx.qualityGerunds.length > 0);
    } }, directives: [_angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabGroup, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTab, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabContent, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgForOf, _nouns_listing_nouns_listing_component__WEBPACK_IMPORTED_MODULE_3__.NounsListingComponent], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJnZXJ1bmRzLmNvbXBvbmVudC5jc3MifQ== */"] });


/***/ }),

/***/ 9197:
/*!********************************************************!*\
  !*** ./src/app/initial-sarf/initial-sarf.component.ts ***!
  \********************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "InitialSarfComponent": function() { return /* binding */ InitialSarfComponent; }
/* harmony export */ });
/* harmony import */ var _models_Utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/Utils */ 4282);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/flex-layout/flex */ 582);
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/button */ 781);






class InitialSarfComponent {
    constructor(route, appNotificationService) {
        this.route = route;
        this.appNotificationService = appNotificationService;
    }
    ngOnInit() {
        this.verbSelectionDetail = _models_Utils__WEBPACK_IMPORTED_MODULE_0__.Utils.getVerbSelectionDetail(this.route);
        this.appNotificationService.broadcastVerbSelected(this.verbSelectionDetail);
    }
    getActiveLink() {
        return this.getPath() + "/active";
    }
    getPassiveLink() {
        return this.getPath() + "/passive";
    }
    getNounsLink() {
        return this.getPath() + "/nouns";
    }
    getGerundsLink() {
        return this.getPath() + "/gerunds";
    }
    getPath() {
        return "/" + this.route.snapshot.url.map(m => m.path).join("/");
    }
}
InitialSarfComponent.ɵfac = function InitialSarfComponent_Factory(t) { return new (t || InitialSarfComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_3__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_1__.AppNotificationsService)); };
InitialSarfComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵdefineComponent"]({ type: InitialSarfComponent, selectors: [["app-initial-sarf"]], decls: 10, vars: 4, consts: [[1, "containerX"], ["fxLayout", "row", "fxLayoutGap", "3px", "fxLayoutAlign", "center center", 1, "container"], ["mat-raised-button", "", "color", "primary", "fxFlex", "", 3, "routerLink"]], template: function InitialSarfComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](2, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](3, "\u0627\u0644\u0623\u0641\u0639\u0627\u0644 \u0627\u0644\u0645\u0628\u0646\u064A\u0629 \u0644\u0644\u0645\u0639\u0644\u0648\u0645");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](4, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](5, "\u0627\u0644\u0623\u0641\u0639\u0627\u0644 \u0627\u0644\u0645\u0628\u0646\u064A\u0629 \u0644\u0644\u0645\u062C\u0647\u0648\u0644");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](6, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](7, "\u0627\u0644\u0623\u0633\u0645\u0627\u0621 \u0627\u0644\u0645\u0634\u062A\u0642\u0629");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementStart"](8, "button", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵtext"](9, "\u0627\u0644\u0645\u0635\u0627\u062F\u0631");
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpropertyInterpolate"]("routerLink", ctx.getActiveLink());
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpropertyInterpolate"]("routerLink", ctx.getPassiveLink());
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpropertyInterpolate"]("routerLink", ctx.getNounsLink());
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_2__["ɵɵpropertyInterpolate"]("routerLink", ctx.getGerundsLink());
    } }, directives: [_angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__.DefaultLayoutDirective, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__.DefaultLayoutGapDirective, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__.DefaultLayoutAlignDirective, _angular_material_button__WEBPACK_IMPORTED_MODULE_5__.MatButton, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_4__.DefaultFlexDirective, _angular_router__WEBPACK_IMPORTED_MODULE_3__.RouterLink], styles: [".containerX[_ngcontent-%COMP%] {\n    margin:-5px 100px;\n}\n\nbutton[_ngcontent-%COMP%] {\n    font-size: 1.0em;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbImluaXRpYWwtc2FyZi5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksaUJBQWlCO0FBQ3JCOztBQUVBO0lBQ0ksZ0JBQWdCO0FBQ3BCIiwiZmlsZSI6ImluaXRpYWwtc2FyZi5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLmNvbnRhaW5lclgge1xuICAgIG1hcmdpbjotNXB4IDEwMHB4O1xufVxuXG5idXR0b24ge1xuICAgIGZvbnQtc2l6ZTogMS4wZW07XG59Il19 */"] });


/***/ }),

/***/ 8696:
/*!************************************!*\
  !*** ./src/app/material-module.ts ***!
  \************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "AppMaterialModule": function() { return /* binding */ AppMaterialModule; }
/* harmony export */ });
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material/card */ 2118);
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/form-field */ 5788);
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/material/grid-list */ 5937);
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/input */ 4742);
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/toolbar */ 4106);
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/button */ 781);
/* harmony import */ var _angular_material_list__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/list */ 8417);
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/icon */ 2529);
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/tabs */ 9348);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);










class AppMaterialModule {
}
AppMaterialModule.ɵfac = function AppMaterialModule_Factory(t) { return new (t || AppMaterialModule)(); };
AppMaterialModule.ɵmod = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: AppMaterialModule });
AppMaterialModule.ɵinj = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ imports: [_angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__.MatToolbarModule,
        _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__.MatFormFieldModule,
        _angular_material_input__WEBPACK_IMPORTED_MODULE_3__.MatInputModule,
        _angular_material_card__WEBPACK_IMPORTED_MODULE_4__.MatCardModule,
        _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__.MatGridListModule,
        _angular_material_button__WEBPACK_IMPORTED_MODULE_6__.MatButtonModule,
        _angular_material_list__WEBPACK_IMPORTED_MODULE_7__.MatListModule,
        _angular_material_icon__WEBPACK_IMPORTED_MODULE_8__.MatIconModule,
        _angular_material_tabs__WEBPACK_IMPORTED_MODULE_9__.MatTabsModule] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppMaterialModule, { exports: [_angular_material_toolbar__WEBPACK_IMPORTED_MODULE_1__.MatToolbarModule,
        _angular_material_form_field__WEBPACK_IMPORTED_MODULE_2__.MatFormFieldModule,
        _angular_material_input__WEBPACK_IMPORTED_MODULE_3__.MatInputModule,
        _angular_material_card__WEBPACK_IMPORTED_MODULE_4__.MatCardModule,
        _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__.MatGridListModule,
        _angular_material_button__WEBPACK_IMPORTED_MODULE_6__.MatButtonModule,
        _angular_material_list__WEBPACK_IMPORTED_MODULE_7__.MatListModule,
        _angular_material_icon__WEBPACK_IMPORTED_MODULE_8__.MatIconModule,
        _angular_material_tabs__WEBPACK_IMPORTED_MODULE_9__.MatTabsModule] }); })();


/***/ }),

/***/ 4282:
/*!*********************************!*\
  !*** ./src/app/models/Utils.ts ***!
  \*********************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "Utils": function() { return /* binding */ Utils; }
/* harmony export */ });
class Utils {
    static getVerbSelectionDetail(route) {
        const verb = route.snapshot.paramMap.get('verb');
        const segments = route.snapshot.url;
        let conjugationClass = 0;
        let formula = 0;
        const verbSize = segments[1].path;
        const augmentation = segments[2].path;
        if (verbSize === this.tri) {
            if (augmentation === this.unaugmented) {
                conjugationClass = Number.parseInt(route.snapshot.paramMap.get('class'));
            }
            else if (augmentation === this.augmented) {
                formula = Number.parseInt(route.snapshot.paramMap.get('formula'));
            }
        }
        else if (verbSize === this.quad) {
            if (augmentation === this.augmented) {
                formula = Number.parseInt(route.snapshot.paramMap.get('formula'));
            }
        }
        const verbSelectionDetail = {
            verb: verb,
            isTri: verbSize === this.tri,
            isAugmented: augmentation === this.augmented,
            formula: formula,
            conjugationClass: conjugationClass
        };
        return verbSelectionDetail;
    }
}
Utils.augmented = 'a';
Utils.unaugmented = 'u';
Utils.tri = 'tri';
Utils.quad = 'quad';


/***/ }),

/***/ 1348:
/*!********************************************!*\
  !*** ./src/app/models/conjugationclass.ts ***!
  \********************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "ConjugationClassStatic": function() { return /* binding */ ConjugationClassStatic; },
/* harmony export */   "UnaugmentedTriConjugationClass": function() { return /* binding */ UnaugmentedTriConjugationClass; },
/* harmony export */   "AugmentedTriConjugationClass": function() { return /* binding */ AugmentedTriConjugationClass; },
/* harmony export */   "UnaugmentedQuadConjugationClass": function() { return /* binding */ UnaugmentedQuadConjugationClass; },
/* harmony export */   "AugmentedQuadConjugationClass": function() { return /* binding */ AugmentedQuadConjugationClass; }
/* harmony export */ });
class ConjugationClassStatic {
}
ConjugationClassStatic.TriFirstConjugationClass = 'فعَل يفْعُل';
ConjugationClassStatic.TriSecondConjugationClass = 'فعَل يفْعِل';
ConjugationClassStatic.TriThirdConjugationClass = 'فعَل يفْعَل';
ConjugationClassStatic.TriForthConjugationClass = 'فعِل يفْعَل';
ConjugationClassStatic.TriFifthConjugationClass = 'فعُل يفْعُل';
ConjugationClassStatic.TriSixthConjugationClass = 'فعِل يفْعِل';
ConjugationClassStatic.TriAugmentedByOneFirstConjugationClass = 'أفْعَل يُفْعِل';
ConjugationClassStatic.TriAugmentedByOneSecondConjugationClass = 'فعَّل يُفْعِّل';
ConjugationClassStatic.TriAugmentedByOneThirdConjugationClass = 'فاعَل يُفاعِل';
ConjugationClassStatic.TriAugmentedByTwoFirstConjugationClass = 'انْفَعَل يَنْفَعِل';
ConjugationClassStatic.TriAugmentedByTwoSecondConjugationClass = 'افْتَعَل يَفْتَعِل';
ConjugationClassStatic.TriAugmentedByTwoThirdConjugationClass = 'افْعَلَّ يَفْعَلُّ';
ConjugationClassStatic.TriAugmentedByTwoForthConjugationClass = 'تَفاعَل يَتَفاعَل';
ConjugationClassStatic.TriAugmentedByTwoFifthConjugationClass = 'تَفَعَّل يَتَفَعَّل';
ConjugationClassStatic.TriAugmentedByThreeFirstConjugationClass = 'اسْتَفْعَل يَسْتَفْعِل';
ConjugationClassStatic.TriAugmentedByThreeSecConjugationClass = 'افْعَوْعَل يَفْعَوْعِل';
ConjugationClassStatic.TriAugmentedByThreeThirdConjugationClass = 'افْعَوَّل يَفْعَوِّل';
ConjugationClassStatic.TriAugmentedByThreeForthConjugationClass = 'افْعَالَّ يَفْعَالُّ';
ConjugationClassStatic.QuadFirstClassLabel = 'فَعْلَل يُفَعْلِل';
ConjugationClassStatic.QuadAugmentedFormulaLabel1 = 'تَفْعَل يَتَفَعْلَل';
ConjugationClassStatic.QuadAugmentedFormulaLabel3 = 'افْعَلَلّ يَفعَلِلّ';
ConjugationClassStatic.QuadAugmentedFormulaLabel2 = 'افْعَنْلَل يَفْعَنْلِل';
class UnaugmentedTriConjugationClass {
    constructor(classNumber, label, content, root) {
        this.classNumber = classNumber;
        this.label = label;
        this.content = content;
        this.root = root;
        this.reference = `/verb/tri/u/${root}/${classNumber}`;
    }
}
class AugmentedTriConjugationClass {
    constructor(formulaNumber, label, content, root) {
        this.formulaNumber = formulaNumber;
        this.label = label;
        this.content = content;
        this.root = root;
        this.reference = `/verb/tri/a/${root}/${formulaNumber}`;
    }
}
class UnaugmentedQuadConjugationClass {
    constructor(label, content, root) {
        this.label = label;
        this.content = content;
        this.root = root;
        this.reference = `/verb/quad/u/${root}`;
    }
}
class AugmentedQuadConjugationClass {
    constructor(formulaNumber, label, content, root) {
        this.formulaNumber = formulaNumber;
        this.label = label;
        this.content = content;
        this.root = root;
        this.reference = `/verb/quad/a/${root}/${formulaNumber}`;
    }
}


/***/ }),

/***/ 1185:
/*!********************************************!*\
  !*** ./src/app/models/conjugationgroup.ts ***!
  \********************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "ConjugationGroup": function() { return /* binding */ ConjugationGroup; }
/* harmony export */ });
class ConjugationGroup {
    constructor(label, conjugationClasses) {
        this.label = label;
        this.conjugationClasses = conjugationClasses;
    }
}
ConjugationGroup.TriUnaugmentedLabel = 'الأفعال الثلاثية المجردة';
ConjugationGroup.TriAugmentedByOneLabel = 'الأفعال الثلاثية المزيدة بحرف';
ConjugationGroup.TriAugmentedByTwoLabel = 'الأفعال الثلاثية المزيدة بحرفين';
ConjugationGroup.TriAugmentedByThreeLabel = 'الأفعال الثلاثية المزيدة بثلاثة أحرف';
ConjugationGroup.QuadUnaugmentedLabel = 'الأفعال الرباعية المجردة';
ConjugationGroup.QuadAugmentedByOneLabel = 'الأفعال الرباعية المزيدة بحرف';
ConjugationGroup.QuadAugmentedByTwoLabel = 'الأفعال الرباعية المزيدة بحرفين';


/***/ }),

/***/ 8416:
/*!**************************************************!*\
  !*** ./src/app/models/quad-conjugation-group.ts ***!
  \**************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "QuadConjugationGroup": function() { return /* binding */ QuadConjugationGroup; }
/* harmony export */ });
class QuadConjugationGroup {
    constructor(unaugmented, augmentedByOne, augmentedByTwo) {
        this.unaugmented = unaugmented;
        this.augmentedByOne = augmentedByOne;
        this.augmentedByTwo = augmentedByTwo;
    }
}


/***/ }),

/***/ 9828:
/*!********************************************************!*\
  !*** ./src/app/models/trilateral-conjugation-group.ts ***!
  \********************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "TrilateralConjugationGroup": function() { return /* binding */ TrilateralConjugationGroup; }
/* harmony export */ });
class TrilateralConjugationGroup {
    constructor(unaugmented, augmentedByOne, augmentedByTwo, augmentedByThree) {
        this.unaugmented = unaugmented;
        this.augmentedByOne = augmentedByOne;
        this.augmentedByTwo = augmentedByTwo;
        this.augmentedByThree = augmentedByThree;
    }
}


/***/ }),

/***/ 1142:
/*!**************************************************!*\
  !*** ./src/app/not-found/not-found.component.ts ***!
  \**************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "NotFoundComponent": function() { return /* binding */ NotFoundComponent; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);

class NotFoundComponent {
    constructor() { }
    ngOnInit() {
    }
}
NotFoundComponent.ɵfac = function NotFoundComponent_Factory(t) { return new (t || NotFoundComponent)(); };
NotFoundComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: NotFoundComponent, selectors: [["app-not-found"]], decls: 2, vars: 0, template: function NotFoundComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "p");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " \u0644\u0645 \u064A\u0631\u062F \u0647\u0630\u0627 \u0627\u0644\u062C\u0630\u0631 \u0641\u064A \u0642\u0627\u0639\u062F\u0629 \u0627\u0644\u0645\u0639\u0637\u064A\u0627\u062A\n");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJub3QtZm91bmQuY29tcG9uZW50LmNzcyJ9 */"] });


/***/ }),

/***/ 1413:
/*!**********************************************************!*\
  !*** ./src/app/nouns-listing/nouns-listing.component.ts ***!
  \**********************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "NounsListingComponent": function() { return /* binding */ NounsListingComponent; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/button */ 781);



function NounsListingComponent_div_43_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const noun_r3 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", noun_r3, " ");
} }
function NounsListingComponent_div_44_Template(rf, ctx) { if (rf & 1) {
    const _r5 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_44_Template_button_click_1_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r5); const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r4.setCase("indefinite"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "\u0641\u064A \u062D\u0627\u0644\u0629 \u0627\u0644\u0646\u0643\u0631\u0629");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_44_Template_button_click_3_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r5); const ctx_r6 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r6.setCase("annexed"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "\u0641\u064A \u062D\u0627\u0644\u0629 \u0627\u0644\u0625\u0636\u0627\u0641\u0629");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_44_Template_button_click_5_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r5); const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r7.setCase("definite"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\u0641\u064A \u062D\u0627\u0644\u0629 \u0627\u0644\u0645\u0639\u0631\u0641\u0629");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r1.isCaseButtonDisabled("indefinite"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r1.isCaseButtonDisabled("annexed"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r1.isCaseButtonDisabled("definite"));
} }
function NounsListingComponent_div_45_Template(rf, ctx) { if (rf & 1) {
    const _r9 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_45_Template_button_click_1_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r9); const ctx_r8 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r8.setCase("annexedToDefinite"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "\u0627\u0644\u0645\u0636\u0627\u0641 \u0625\u0644\u0649 \u0645\u0639\u0631\u0641\u0629");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_45_Template_button_click_3_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r9); const ctx_r10 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r10.setCase("definite"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "\u0627\u0644\u0645\u0639\u0631\u0641 \u0628\u0623\u0644\u0640");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_45_Template_button_click_5_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r9); const ctx_r11 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r11.setCase("annexedToIndefinite"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\u0627\u0644\u0645\u0636\u0627\u0641 \u0625\u0644\u0649 \u0646\u0643\u0631\u0629");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function NounsListingComponent_div_45_Template_button_click_7_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r9); const ctx_r12 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r12.setCase("indefiniteNouns"); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\u063A\u064A\u0631 \u0627\u0644\u0645\u0636\u0627\u0641");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r2.isCaseButtonDisabled("annexedToDefinite"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r2.isCaseButtonDisabled("definite"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r2.isCaseButtonDisabled("annexedToIndefinite"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("disabled", ctx_r2.isCaseButtonDisabled("indefiniteNouns"));
} }
class NounsListingComponent {
    constructor() {
        this.isElative = false;
    }
    ngOnInit() {
        this.setCase(this.isElative ? 'annexedToDefinite' : 'indefinite');
    }
    isCaseButtonDisabled(theCase) {
        return this.case === theCase;
    }
    setCase(theCase) {
        this.case = theCase;
        if (this.isElative) {
            if (this.case === 'definite') {
                this.nouns = this.definiteNouns;
            }
            else if (this.case === 'annexedToIndefinite') {
                this.nouns = this.annexedToIndefinite;
            }
            else if (this.case === 'annexedToDefinite') {
                this.nouns = this.annexedToDefinite;
            }
            else {
                this.nouns = this.indefiniteNouns;
            }
        }
        else {
            if (this.case === 'definite') {
                this.nouns = this.definiteNouns;
            }
            else if (this.case === 'annexed') {
                this.nouns = this.annexedNouns;
            }
            else {
                this.nouns = this.indefiniteNouns;
            }
        }
    }
}
NounsListingComponent.ɵfac = function NounsListingComponent_Factory(t) { return new (t || NounsListingComponent)(); };
NounsListingComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: NounsListingComponent, selectors: [["app-nouns-listing"]], inputs: { indefiniteNouns: "indefiniteNouns", annexedNouns: "annexedNouns", definiteNouns: "definiteNouns", isElative: "isElative", annexedToIndefinite: "annexedToIndefinite", annexedToDefinite: "annexedToDefinite" }, decls: 46, vars: 3, consts: [[1, "main-grid"], [1, "mas", "gender"], [1, "text"], [1, "fem", "gender"], [1, "nominative", "column1"], [1, "accusative", "column1"], [1, "genitive", "column1"], [1, "nominativeCount1", "count"], [1, "nominativeCount2", "count"], [1, "nominativeCount3", "count"], [1, "accusativeCount1", "count"], [1, "accusativeCount2", "count"], [1, "accusativeCount3", "count"], [1, "genitiveCount1", "count"], [1, "genitiveCount2", "count"], [1, "genitiveCount3", "count"], ["class", "noun", 4, "ngFor", "ngForOf"], ["class", "row3", 4, "ngIf"], [1, "noun"], [1, "text", "nounText"], [1, "row3"], ["mat-raised-button", "", "color", "primary", 3, "disabled", "click"]], template: function NounsListingComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "\u0645\u0630\u0643\u0631");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\u0645\u0624\u0646\u062B");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, " \u0627\u0644\u0631\u0641\u0639 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, " \u0627\u0644\u0646\u0635\u0628 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, " \u0627\u0644\u062C\u0631 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, " \u0645\u0641\u0631\u062F ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21, " \u0645\u062B\u0646\u0649 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](24, " \u062C\u0645\u0639 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27, " \u0645\u0641\u0631\u062F ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](30, " \u0645\u062B\u0646\u0649 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](33, " \u062C\u0645\u0639 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](36, " \u0645\u0641\u0631\u062F ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](38, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](39, " \u0645\u062B\u0646\u0649 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "div", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](42, " \u062C\u0645\u0639 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](43, NounsListingComponent_div_43_Template, 3, 1, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](44, NounsListingComponent_div_44_Template, 7, 3, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](45, NounsListingComponent_div_45_Template, 9, 4, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](43);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.nouns);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", !ctx.isElative);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isElative);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_1__.NgForOf, _angular_common__WEBPACK_IMPORTED_MODULE_1__.NgIf, _angular_material_button__WEBPACK_IMPORTED_MODULE_2__.MatButton], styles: [".main-grid[_ngcontent-%COMP%] {\n    display: grid;\n    width: 100%;\n    grid-template-columns: 1fr 1fr 5fr 5fr;\n    grid-template-rows: 1fr repeat(9, 2fr) 3fr;\n    background-color: blanchedalmond;\n}\n\n.gender[_ngcontent-%COMP%] {\n    background-color: wheat;\n    display: flex;\n    justify-content: center;\n    align-items: center;\n    border: 1px solid gray;\n}\n\n.text[_ngcontent-%COMP%] {\n    color: black;\n    font-size: 1.5em;\n}\n\n.mas[_ngcontent-%COMP%] {\n    grid-column: 3 / 4;\n}\n\n.fem[_ngcontent-%COMP%] {\n    grid-column: 4 / 5;\n}\n\n.column1[_ngcontent-%COMP%] {\n    background-color: wheat;\n    display: flex;\n    justify-content: center;\n    align-items: center;\n    border: 1px solid gray;\n}\n\n.nominative[_ngcontent-%COMP%] {\n    grid-row: 2 / 5;\n}\n\n.accusative[_ngcontent-%COMP%] {\n    grid-row: 5 / 8;\n}\n\n.genitive[_ngcontent-%COMP%] {\n    grid-row: 8 / 11;\n}\n\n.count[_ngcontent-%COMP%] {\n    background-color: wheat;\n    display: flex;\n    justify-content: center;\n    align-items: center;\n}\n\n.nominativeCount1[_ngcontent-%COMP%] {\n    grid-row: 2 / 3;\n    border-top: 1px solid gray;\n    border-bottom: 1px solid gray;\n}\n\n.nominativeCount2[_ngcontent-%COMP%] {\n    grid-row: 3 / 4;\n    border-bottom: 1px solid gray;\n}\n\n.nominativeCount3[_ngcontent-%COMP%] {\n    grid-row: 4 / 5;\n    border-bottom: 1px solid gray;\n}\n\n.accusativeCount1[_ngcontent-%COMP%] {\n    grid-row: 5 /6;\n    border-bottom: 1px solid gray;\n}\n\n.accusativeCount2[_ngcontent-%COMP%] {\n    grid-row: 6/ 7;\n    border-bottom: 1px solid gray;\n}\n\n.accusativeCount3[_ngcontent-%COMP%] {\n    grid-row: 7 / 8;\n    border-bottom: 1px solid gray;\n}\n\n.genitiveCount1[_ngcontent-%COMP%] {\n    grid-row: 8 / 9;\n    border-bottom: 1px solid gray;\n}\n\n.genitiveCount2[_ngcontent-%COMP%] {\n    grid-row: 9 / 10;\n    border-bottom: 1px solid gray;\n}\n\n.genitiveCount3[_ngcontent-%COMP%] {\n    grid-row: 10 / 11;\n    border-bottom: 1px solid gray;\n}\n\n.column2[_ngcontent-%COMP%] {\n    grid-column-start: 2;\n    grid-column-end: 4;\n    grid-row: 2 / 12;\n}\n\n.row3[_ngcontent-%COMP%] {\n    display: flex;\n    flex-direction: row;\n    flex-grow: 100px;\n    grid-row-start: 11;\n    grid-column: 3 / 5;\n}\n\n.row3[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\n    width: 100%;\n    align-self: stretch;\n    justify-self: stretch;\n}\n\n.noun[_ngcontent-%COMP%] {\n    display: flex;\n    justify-content: center;\n    align-items: center;\n    border: 1px solid gray;\n}\n\n.nounText[_ngcontent-%COMP%] {\n    font-size: xx-large;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIm5vdW5zLWxpc3RpbmcuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGFBQWE7SUFDYixXQUFXO0lBQ1gsc0NBQXNDO0lBQ3RDLDBDQUEwQztJQUMxQyxnQ0FBZ0M7QUFDcEM7O0FBRUE7SUFDSSx1QkFBdUI7SUFDdkIsYUFBYTtJQUNiLHVCQUF1QjtJQUN2QixtQkFBbUI7SUFDbkIsc0JBQXNCO0FBQzFCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHVCQUF1QjtJQUN2QixhQUFhO0lBQ2IsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtJQUNuQixzQkFBc0I7QUFDMUI7O0FBRUE7SUFDSSxlQUFlO0FBQ25COztBQUVBO0lBQ0ksZUFBZTtBQUNuQjs7QUFFQTtJQUNJLGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLHVCQUF1QjtJQUN2QixhQUFhO0lBQ2IsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtBQUN2Qjs7QUFFQTtJQUNJLGVBQWU7SUFDZiwwQkFBMEI7SUFDMUIsNkJBQTZCO0FBQ2pDOztBQUVBO0lBQ0ksZUFBZTtJQUNmLDZCQUE2QjtBQUNqQzs7QUFFQTtJQUNJLGVBQWU7SUFDZiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxjQUFjO0lBQ2QsNkJBQTZCO0FBQ2pDOztBQUVBO0lBQ0ksY0FBYztJQUNkLDZCQUE2QjtBQUNqQzs7QUFFQTtJQUNJLGVBQWU7SUFDZiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxlQUFlO0lBQ2YsNkJBQTZCO0FBQ2pDOztBQUVBO0lBQ0ksZ0JBQWdCO0lBQ2hCLDZCQUE2QjtBQUNqQzs7QUFFQTtJQUNJLGlCQUFpQjtJQUNqQiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxvQkFBb0I7SUFDcEIsa0JBQWtCO0lBQ2xCLGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLGFBQWE7SUFDYixtQkFBbUI7SUFDbkIsZ0JBQWdCO0lBQ2hCLGtCQUFrQjtJQUNsQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLHFCQUFxQjtBQUN6Qjs7QUFFQTtJQUNJLGFBQWE7SUFDYix1QkFBdUI7SUFDdkIsbUJBQW1CO0lBQ25CLHNCQUFzQjtBQUMxQjs7QUFFQTtJQUNJLG1CQUFtQjtBQUN2QiIsImZpbGUiOiJub3Vucy1saXN0aW5nLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWFpbi1ncmlkIHtcbiAgICBkaXNwbGF5OiBncmlkO1xuICAgIHdpZHRoOiAxMDAlO1xuICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogMWZyIDFmciA1ZnIgNWZyO1xuICAgIGdyaWQtdGVtcGxhdGUtcm93czogMWZyIHJlcGVhdCg5LCAyZnIpIDNmcjtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiBibGFuY2hlZGFsbW9uZDtcbn1cblxuLmdlbmRlciB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hlYXQ7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBqdXN0aWZ5LWNvbnRlbnQ6IGNlbnRlcjtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIGJvcmRlcjogMXB4IHNvbGlkIGdyYXk7XG59XG5cbi50ZXh0IHtcbiAgICBjb2xvcjogYmxhY2s7XG4gICAgZm9udC1zaXplOiAxLjVlbTtcbn1cblxuLm1hcyB7XG4gICAgZ3JpZC1jb2x1bW46IDMgLyA0O1xufVxuXG4uZmVtIHtcbiAgICBncmlkLWNvbHVtbjogNCAvIDU7XG59XG5cbi5jb2x1bW4xIHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGVhdDtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgYm9yZGVyOiAxcHggc29saWQgZ3JheTtcbn1cblxuLm5vbWluYXRpdmUge1xuICAgIGdyaWQtcm93OiAyIC8gNTtcbn1cblxuLmFjY3VzYXRpdmUge1xuICAgIGdyaWQtcm93OiA1IC8gODtcbn1cblxuLmdlbml0aXZlIHtcbiAgICBncmlkLXJvdzogOCAvIDExO1xufVxuXG4uY291bnQge1xuICAgIGJhY2tncm91bmQtY29sb3I6IHdoZWF0O1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAganVzdGlmeS1jb250ZW50OiBjZW50ZXI7XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbn1cblxuLm5vbWluYXRpdmVDb3VudDEge1xuICAgIGdyaWQtcm93OiAyIC8gMztcbiAgICBib3JkZXItdG9wOiAxcHggc29saWQgZ3JheTtcbiAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgZ3JheTtcbn1cblxuLm5vbWluYXRpdmVDb3VudDIge1xuICAgIGdyaWQtcm93OiAzIC8gNDtcbiAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgZ3JheTtcbn1cblxuLm5vbWluYXRpdmVDb3VudDMge1xuICAgIGdyaWQtcm93OiA0IC8gNTtcbiAgICBib3JkZXItYm90dG9tOiAxcHggc29saWQgZ3JheTtcbn1cblxuLmFjY3VzYXRpdmVDb3VudDEge1xuICAgIGdyaWQtcm93OiA1IC82O1xuICAgIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCBncmF5O1xufVxuXG4uYWNjdXNhdGl2ZUNvdW50MiB7XG4gICAgZ3JpZC1yb3c6IDYvIDc7XG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIGdyYXk7XG59XG5cbi5hY2N1c2F0aXZlQ291bnQzIHtcbiAgICBncmlkLXJvdzogNyAvIDg7XG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIGdyYXk7XG59XG5cbi5nZW5pdGl2ZUNvdW50MSB7XG4gICAgZ3JpZC1yb3c6IDggLyA5O1xuICAgIGJvcmRlci1ib3R0b206IDFweCBzb2xpZCBncmF5O1xufVxuXG4uZ2VuaXRpdmVDb3VudDIge1xuICAgIGdyaWQtcm93OiA5IC8gMTA7XG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIGdyYXk7XG59XG5cbi5nZW5pdGl2ZUNvdW50MyB7XG4gICAgZ3JpZC1yb3c6IDEwIC8gMTE7XG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkIGdyYXk7XG59XG5cbi5jb2x1bW4yIHtcbiAgICBncmlkLWNvbHVtbi1zdGFydDogMjtcbiAgICBncmlkLWNvbHVtbi1lbmQ6IDQ7XG4gICAgZ3JpZC1yb3c6IDIgLyAxMjtcbn1cblxuLnJvdzMge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZmxleC1kaXJlY3Rpb246IHJvdztcbiAgICBmbGV4LWdyb3c6IDEwMHB4O1xuICAgIGdyaWQtcm93LXN0YXJ0OiAxMTtcbiAgICBncmlkLWNvbHVtbjogMyAvIDU7XG59XG5cbi5yb3czIGJ1dHRvbiB7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgYWxpZ24tc2VsZjogc3RyZXRjaDtcbiAgICBqdXN0aWZ5LXNlbGY6IHN0cmV0Y2g7XG59XG5cbi5ub3VuIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGp1c3RpZnktY29udGVudDogY2VudGVyO1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gICAgYm9yZGVyOiAxcHggc29saWQgZ3JheTtcbn1cblxuLm5vdW5UZXh0IHtcbiAgICBmb250LXNpemU6IHh4LWxhcmdlO1xufSJdfQ== */"] });


/***/ }),

/***/ 804:
/*!**********************************************************!*\
  !*** ./src/app/passive-verbs/passive-verbs.component.ts ***!
  \**********************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "PassiveVerbsComponent": function() { return /* binding */ PassiveVerbsComponent; }
/* harmony export */ });
/* harmony import */ var _models_Utils__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/Utils */ 4282);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material/tabs */ 9348);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _sarf_verb_pronouns_sarf_verb_pronouns_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../sarf-verb-pronouns/sarf-verb-pronouns.component */ 3157);








function PassiveVerbsComponent_ng_template_2_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function PassiveVerbsComponent_ng_template_2_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const pastGroup_r11 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", pastGroup_r11.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", pastGroup_r11.verbs);
} }
function PassiveVerbsComponent_ng_template_2_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_2_ng_template_1_div_1_Template, 3, 2, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r7.pastGroups);
} }
function PassiveVerbsComponent_ng_template_2_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](1, "app-sarf-verb-pronouns", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const pastGroup_r13 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", pastGroup_r13.verbs);
} }
function PassiveVerbsComponent_ng_template_2_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, PassiveVerbsComponent_ng_template_2_ng_template_3_div_0_Template, 2, 1, "div", 10);
} if (rf & 2) {
    const ctx_r9 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r9.pastGroups);
} }
function PassiveVerbsComponent_ng_template_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, PassiveVerbsComponent_ng_template_2_div_0_Template, 1, 0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_2_ng_template_1_Template, 2, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, PassiveVerbsComponent_ng_template_2_ng_template_3_Template, 1, 1, "ng-template", null, 9, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r0.showSubTabs())("ngIfThen", _r6)("ngIfElse", _r8);
} }
function PassiveVerbsComponent_ng_template_4_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function PassiveVerbsComponent_ng_template_4_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const nominativePresent_r20 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", nominativePresent_r20.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", nominativePresent_r20.verbs);
} }
function PassiveVerbsComponent_ng_template_4_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_4_ng_template_1_div_1_Template, 3, 2, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r16 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r16.nominativePresentGroups);
} }
function PassiveVerbsComponent_ng_template_4_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 12);
} if (rf & 2) {
    const ctx_r18 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r18.nominativePresentGroups[0].verbs);
} }
function PassiveVerbsComponent_ng_template_4_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, PassiveVerbsComponent_ng_template_4_div_0_Template, 1, 0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_4_ng_template_1_Template, 2, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, PassiveVerbsComponent_ng_template_4_ng_template_3_Template, 1, 1, "ng-template", null, 9, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r15 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r17 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r1.showSubTabs())("ngIfThen", _r15)("ngIfElse", _r17);
} }
function PassiveVerbsComponent_ng_template_6_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function PassiveVerbsComponent_ng_template_6_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const accusativePresent_r27 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", accusativePresent_r27.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", accusativePresent_r27.verbs);
} }
function PassiveVerbsComponent_ng_template_6_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_6_ng_template_1_div_1_Template, 3, 2, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r23 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r23.accusativePresentGroups);
} }
function PassiveVerbsComponent_ng_template_6_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 12);
} if (rf & 2) {
    const ctx_r25 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r25.accusativePresentGroups[0].verbs);
} }
function PassiveVerbsComponent_ng_template_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, PassiveVerbsComponent_ng_template_6_div_0_Template, 1, 0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_6_ng_template_1_Template, 2, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, PassiveVerbsComponent_ng_template_6_ng_template_3_Template, 1, 1, "ng-template", null, 9, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r22 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r24 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r2.showSubTabs())("ngIfThen", _r22)("ngIfElse", _r24);
} }
function PassiveVerbsComponent_ng_template_8_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function PassiveVerbsComponent_ng_template_8_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const jussivePresent_r34 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", jussivePresent_r34.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", jussivePresent_r34.verbs);
} }
function PassiveVerbsComponent_ng_template_8_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_8_ng_template_1_div_1_Template, 3, 2, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r30 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r30.jussivePresentGroups);
} }
function PassiveVerbsComponent_ng_template_8_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 12);
} if (rf & 2) {
    const ctx_r32 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r32.jussivePresentGroups[0].verbs);
} }
function PassiveVerbsComponent_ng_template_8_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, PassiveVerbsComponent_ng_template_8_div_0_Template, 1, 0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_8_ng_template_1_Template, 2, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, PassiveVerbsComponent_ng_template_8_ng_template_3_Template, 1, 1, "ng-template", null, 9, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r29 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r31 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r3.showSubTabs())("ngIfThen", _r29)("ngIfElse", _r31);
} }
function PassiveVerbsComponent_ng_template_10_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "div");
} }
function PassiveVerbsComponent_ng_template_10_ng_template_1_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](2, "app-sarf-verb-pronouns", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const emphasizedPresent_r41 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵpropertyInterpolate"]("label", emphasizedPresent_r41.key);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", emphasizedPresent_r41.verbs);
} }
function PassiveVerbsComponent_ng_template_10_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_10_ng_template_1_div_1_Template, 3, 2, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r37 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngForOf", ctx_r37.emphasizedPresentGroups);
} }
function PassiveVerbsComponent_ng_template_10_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelement"](0, "app-sarf-verb-pronouns", 12);
} if (rf & 2) {
    const ctx_r39 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("verbs", ctx_r39.emphasizedPresentGroups[0].verbs);
} }
function PassiveVerbsComponent_ng_template_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](0, PassiveVerbsComponent_ng_template_10_div_0_Template, 1, 0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](1, PassiveVerbsComponent_ng_template_10_ng_template_1_Template, 2, 1, "ng-template", null, 8, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](3, PassiveVerbsComponent_ng_template_10_ng_template_3_Template, 1, 1, "ng-template", null, 9, _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r36 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](2);
    const _r38 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵreference"](4);
    const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵproperty"]("ngIf", ctx_r4.showSubTabs())("ngIfThen", _r36)("ngIfElse", _r38);
} }
class PassiveVerbsComponent {
    constructor(sarfService, route, appNotificationsService) {
        this.sarfService = sarfService;
        this.route = route;
        this.appNotificationsService = appNotificationsService;
    }
    ngOnInit() {
        const verbSelectionDetail = _models_Utils__WEBPACK_IMPORTED_MODULE_0__.Utils.getVerbSelectionDetail(this.route);
        this.serviceSubscription = this.sarfService.getPassiveVerbConjugatons(verbSelectionDetail).subscribe(result => {
            console.log('active verbs', result);
            this.pastGroups = result.map(r => ({ 'key': r.key, 'verbs': r.past }));
            this.nominativePresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.nominativePresent }));
            this.accusativePresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.accusativePresent }));
            this.jussivePresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.jussivePresent }));
            ;
            this.emphasizedPresentGroups = result.map(r => ({ 'key': r.key, 'verbs': r.emphasizedPresent }));
        });
        this.appNotificationsService.broadcastVerbSelected(verbSelectionDetail);
    }
    showSubTabs() {
        return this.pastGroups.length > 1;
    }
    ngOnDestroy() {
        var _a;
        (_a = this.serviceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
    }
}
PassiveVerbsComponent.ɵfac = function PassiveVerbsComponent_Factory(t) { return new (t || PassiveVerbsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_1__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_2__.AppNotificationsService)); };
PassiveVerbsComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵdefineComponent"]({ type: PassiveVerbsComponent, selectors: [["app-passive-verbs"]], decls: 11, vars: 0, consts: [["animationDuration", "0ms", "color", "accent", "backgroundColor", "primary", 1, "tab-group"], ["label", "\u0627\u0644\u0645\u0627\u0636\u064A \u0627\u0644\u0645\u062C\u0647\u0648\u0644"], ["matTabContent", ""], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u0631\u0641\u0648\u0639 \u0627\u0644\u0645\u062C\u0647\u0648\u0644"], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u0646\u0635\u0648\u0628 \u0627\u0644\u0645\u062C\u0647\u0648\u0644"], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u062C\u0632\u0648\u0645 \u0627\u0644\u0645\u062C\u0647\u0648\u0644"], ["label", "\u0627\u0644\u0645\u0636\u0627\u0631\u0639 \u0627\u0644\u0645\u0624\u0643\u062F \u0627\u0644\u0645\u062C\u0647\u0648\u0644"], [4, "ngIf", "ngIfThen", "ngIfElse"], ["withSubTabs", ""], ["simpleBlock", ""], [4, "ngFor", "ngForOf"], [3, "label"], [3, "verbs"]], template: function PassiveVerbsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](0, "mat-tab-group", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](1, "mat-tab", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](2, PassiveVerbsComponent_ng_template_2_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](3, "mat-tab", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](4, PassiveVerbsComponent_ng_template_4_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](5, "mat-tab", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](6, PassiveVerbsComponent_ng_template_6_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](7, "mat-tab", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](8, PassiveVerbsComponent_ng_template_8_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementStart"](9, "mat-tab", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵtemplate"](10, PassiveVerbsComponent_ng_template_10_Template, 5, 3, "ng-template", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_4__["ɵɵelementEnd"]();
    } }, directives: [_angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabGroup, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTab, _angular_material_tabs__WEBPACK_IMPORTED_MODULE_6__.MatTabContent, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgIf, _angular_common__WEBPACK_IMPORTED_MODULE_7__.NgForOf, _sarf_verb_pronouns_sarf_verb_pronouns_component__WEBPACK_IMPORTED_MODULE_3__.SarfVerbPronounsComponent], styles: [".mat-tab-label-content[_ngcontent-%COMP%] {\n    font-size: 1.3em;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInBhc3NpdmUtdmVyYnMuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtJQUNJLGdCQUFnQjtBQUNwQiIsImZpbGUiOiJwYXNzaXZlLXZlcmJzLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIubWF0LXRhYi1sYWJlbC1jb250ZW50IHtcbiAgICBmb250LXNpemU6IDEuM2VtO1xufVxuIl19 */"] });


/***/ }),

/***/ 2482:
/*!********************************************************************************************!*\
  !*** ./src/app/quadilateral-conjugation-panel/quadilateral-conjugation-panel.component.ts ***!
  \********************************************************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "QuadilateralConjugationPanelComponent": function() { return /* binding */ QuadilateralConjugationPanelComponent; }
/* harmony export */ });
/* harmony import */ var _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/conjugationclass */ 1348);
/* harmony import */ var _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../models/conjugationgroup */ 1185);
/* harmony import */ var _models_quad_conjugation_group__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../models/quad-conjugation-group */ 8416);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _conjugation_group_conjugation_group_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../conjugation-group/conjugation-group.component */ 40);
/* harmony import */ var _angular_material_list__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/list */ 8417);
/* harmony import */ var _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../not-found/not-found.component */ 1142);











function QuadilateralConjugationPanelComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "div");
} }
function QuadilateralConjugationPanelComponent_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "app-conjugation-group", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](1, "app-conjugation-group", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](2, "app-conjugation-group", 3);
} if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.unaugmented);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.augmentedByOne);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.augmentedByTwo);
} }
function QuadilateralConjugationPanelComponent_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "div");
} }
function QuadilateralConjugationPanelComponent_ng_template_3_ng_template_1_mat_list_item_3_Template(rf, ctx) { if (rf & 1) {
    const _r13 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "mat-list-item");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](1, "a", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵlistener"]("click", function QuadilateralConjugationPanelComponent_ng_template_3_ng_template_1_mat_list_item_3_Template_a_click_1_listener() { const restoredCtx = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵrestoreView"](_r13); const alternative_r11 = restoredCtx.$implicit; const ctx_r12 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"](3); return ctx_r12.navigatTo(alternative_r11.path); });
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
} if (rf & 2) {
    const alternative_r11 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtextInterpolate"](alternative_r11.display);
} }
function QuadilateralConjugationPanelComponent_ng_template_3_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "p");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtext"](1, "\u064A\u0648\u062C\u062F \u0623\u0643\u062B\u0631 \u0645\u0646 \u062C\u0630\u0631. \u0625\u062E\u062A\u0631 \u0623\u062D\u062F \u0627\u0644\u062C\u0630\u0631\u064A\u0646");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](2, "mat-nav-list");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](3, QuadilateralConjugationPanelComponent_ng_template_3_ng_template_1_mat_list_item_3_Template, 3, 1, "mat-list-item", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngForOf", ctx_r7.alternatives);
} }
function QuadilateralConjugationPanelComponent_ng_template_3_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "app-not-found");
} }
function QuadilateralConjugationPanelComponent_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](0, QuadilateralConjugationPanelComponent_ng_template_3_div_0_Template, 1, 0, "div", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](1, QuadilateralConjugationPanelComponent_ng_template_3_ng_template_1_Template, 4, 1, "ng-template", null, 4, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](3, QuadilateralConjugationPanelComponent_ng_template_3_ng_template_3_Template, 1, 0, "ng-template", null, 5, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](2);
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](4);
    const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx_r4.hasAlternatives())("ngIfThen", _r6)("ngIfElse", _r8);
} }
class QuadilateralConjugationPanelComponent {
    constructor(sarfService, route, router, appNotificationsService) {
        this.sarfService = sarfService;
        this.route = route;
        this.router = router;
        this.appNotificationsService = appNotificationsService;
    }
    ngOnInit() {
        this.conjugationGroup = null;
        // tslint:disable-next-line:no-console
        const currentRoot = this.resetSearch();
        this.serviceSubscription = this.sarfService.findSarf(currentRoot).subscribe(rootResult => {
            console.log(rootResult);
            this.processQuadResult(rootResult);
        }, n => console.log(n));
    }
    navigatTo(path) {
        this.router.navigateByUrl('/', { skipLocationChange: true })
            .then(() => this.router.navigate([path]));
    }
    resetSearch() {
        const currentRoot = this.route.snapshot.paramMap.get('root');
        this.conjugationGroup = null;
        this.alternatives = null;
        return currentRoot;
    }
    hasSingleResult() {
        return this.conjugationGroup != null;
    }
    hasAlternatives() {
        return this.alternatives != null && this.alternatives.length > 1;
    }
    processQuadResult(rootResult) {
        if (rootResult == null || rootResult.length == 0) {
            return;
        }
        if (rootResult.length > 1) {
            this.alternatives = rootResult.map(root => ({
                "path": `/tri/${root.root}`,
                "display": root.root
            }));
            return;
        }
        const result = rootResult[0];
        const root = result.root;
        const unaugmented = this.buildQuadUnaugmentedConjugationClasses(result.unaugmentedRoots, root);
        const augmentedByOne = this.buildQuadAugmentedByOneConjugationClasses(result.conjugationResults, root);
        const augmentedByTwo = this.buildQuadAugmentedByTwoConjugationClasses(result.conjugationResults, root);
        this.conjugationGroup = new _models_quad_conjugation_group__WEBPACK_IMPORTED_MODULE_2__.QuadConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo);
        this.appNotificationsService.broadcastRootResult(result);
    }
    buildQuadUnaugmentedConjugationClasses(unaugmentedRoots, root) {
        if (!unaugmentedRoots) {
            return;
        }
        var first = unaugmentedRoots ? unaugmentedRoots[0].display : "";
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.UnaugmentedQuadConjugationClass(_models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.ConjugationClassStatic.QuadFirstClassLabel, first, root)
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.QuadUnaugmentedLabel, conjugationClasses);
    }
    buildQuadAugmentedByOneConjugationClasses(conjugationResults, root) {
        var formula1 = this.getAugmentedRootText(conjugationResults, 1);
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.AugmentedQuadConjugationClass(1, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.ConjugationClassStatic.QuadAugmentedFormulaLabel1, formula1, root),
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.QuadAugmentedByOneLabel, conjugationClasses);
    }
    buildQuadAugmentedByTwoConjugationClasses(conjugationResults, root) {
        var formula2 = this.getAugmentedRootText(conjugationResults, 2);
        var formula3 = this.getAugmentedRootText(conjugationResults, 3);
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.AugmentedQuadConjugationClass(3, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.ConjugationClassStatic.QuadAugmentedFormulaLabel3, formula3, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.AugmentedQuadConjugationClass(2, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_0__.ConjugationClassStatic.QuadAugmentedFormulaLabel2, formula2, root)
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.QuadAugmentedByTwoLabel, conjugationClasses);
    }
    getAugmentedRootText(conjugationResults, formulaNo) {
        return conjugationResults.filter(r => r.conjugationResult.formulaNo === formulaNo)
            .map(r => r.display)
            .join('');
    }
    ngOnDestroy() {
        var _a;
        (_a = this.serviceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
    }
}
QuadilateralConjugationPanelComponent.ɵfac = function QuadilateralConjugationPanelComponent_Factory(t) { return new (t || QuadilateralConjugationPanelComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_3__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.Router), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_4__.AppNotificationsService)); };
QuadilateralConjugationPanelComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineComponent"]({ type: QuadilateralConjugationPanelComponent, selectors: [["app-quadilateral-conjugation-panel"]], decls: 5, vars: 3, consts: [[4, "ngIf", "ngIfThen", "ngIfElse"], ["resultBlock", ""], ["emptyBlock", ""], [3, "conjugationGroup"], ["alternativesBlock", ""], ["notFoundBlock", ""], [4, "ngFor", "ngForOf"], [3, "click"]], template: function QuadilateralConjugationPanelComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](0, QuadilateralConjugationPanelComponent_div_0_Template, 1, 0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](1, QuadilateralConjugationPanelComponent_ng_template_1_Template, 3, 3, "ng-template", null, 1, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](3, QuadilateralConjugationPanelComponent_ng_template_3_Template, 5, 3, "ng-template", null, 2, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
    } if (rf & 2) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](2);
        const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.hasSingleResult())("ngIfThen", _r1)("ngIfElse", _r3);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.NgIf, _conjugation_group_conjugation_group_component__WEBPACK_IMPORTED_MODULE_5__.ConjugationGroupComponent, _angular_material_list__WEBPACK_IMPORTED_MODULE_10__.MatNavList, _angular_common__WEBPACK_IMPORTED_MODULE_9__.NgForOf, _angular_material_list__WEBPACK_IMPORTED_MODULE_10__.MatListItem, _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__.NotFoundComponent], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJxdWFkaWxhdGVyYWwtY29uanVnYXRpb24tcGFuZWwuY29tcG9uZW50LmNzcyJ9 */"] });


/***/ }),

/***/ 8898:
/*!***********************************!*\
  !*** ./src/app/root-type.enum.ts ***!
  \***********************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "RootType": function() { return /* binding */ RootType; }
/* harmony export */ });
var RootType;
(function (RootType) {
    RootType[RootType["None"] = 0] = "None";
    RootType[RootType["Tri"] = 1] = "Tri";
    RootType[RootType["Quad"] = 2] = "Quad";
})(RootType || (RootType = {}));


/***/ }),

/***/ 9047:
/*!****************************************************!*\
  !*** ./src/app/rootsearch/rootsearch.component.ts ***!
  \****************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "MyErrorStateMatcher": function() { return /* binding */ MyErrorStateMatcher; },
/* harmony export */   "RootsearchComponent": function() { return /* binding */ RootsearchComponent; }
/* harmony export */ });
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ 1707);
/* harmony import */ var _root_type_enum__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../root-type.enum */ 8898);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/flex-layout/flex */ 582);
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/form-field */ 5788);
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/input */ 4742);
/* harmony import */ var _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/cdk/bidi */ 772);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/material/button */ 781);
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/material/icon */ 2529);














function RootsearchComponent_mat_error_5_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "mat-error");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "em");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](2, "\u0623\u062F\u062E\u0644 \u062C\u0630\u0631 \u0643\u0644\u0645\u0629 \u0639\u0631\u0628\u064A\u0629 \u062B\u0644\u0627\u062B\u064A \u0623\u0648 \u0631\u0628\u0627\u0639\u064A");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
} }
function RootsearchComponent_mat_error_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "mat-error");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "em");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](2, "\u0627\u0644\u062C\u0630\u0631 ");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](3, "strong");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](4, "\u0636\u0631\u0648\u0631\u064A");
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
} }
/** Error when invalid control is dirty, touched, or submitted. */
class MyErrorStateMatcher {
    isErrorState(control, form) {
        const isSubmitted = form && form.submitted;
        return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
    }
}
class RootsearchComponent {
    constructor(appNotificationsService, sarfService, router) {
        this.appNotificationsService = appNotificationsService;
        this.sarfService = sarfService;
        this.router = router;
        this.rootFormControl = new _angular_forms__WEBPACK_IMPORTED_MODULE_4__.FormControl('', [_angular_forms__WEBPACK_IMPORTED_MODULE_4__.Validators.required]);
        this.matcher = new MyErrorStateMatcher();
        this.hamzaString = "أؤئإ";
        this.appNotificationsService.rootResultRetrieved$.subscribe(rootResult => this.processRootResult(rootResult), err => {
            console.error(err);
        }, () => { });
        this.appNotificationsService.verbSelected$.subscribe(verbSelectionDetail => {
            var _a;
            (_a = this.sarfServiceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
            if (this.currentlySelectedRoot == null) {
                this.retrieveBasicRootInfo(verbSelectionDetail);
            }
            else {
                this.processVerbSelection(verbSelectionDetail);
            }
        });
    }
    retrieveBasicRootInfo(verbSelectionDetail) {
        this.sarfServiceSubscription = this.sarfService.findSarf(verbSelectionDetail.verb).subscribe(result => {
            if (!result || result.length == 0) {
                return;
            }
            this.currentlySelectedRoot = result[0];
            this.processVerbSelection(verbSelectionDetail);
        });
    }
    processVerbSelection(verbSelectionDetail) {
        if (!this.currentlySelectedRoot) {
            return;
        }
        if (!this.rootFormControl.value) {
            /* this happens when we navigate directly to a page, instead of going through search. */
            this.rootFormControl.setValue(this.currentlySelectedRoot.root);
            this.kindOfVerb = this.currentlySelectedRoot.kindOfVerb;
        }
        let transitiveState = '';
        if (verbSelectionDetail.isAugmented) {
            const selection = this.currentlySelectedRoot.conjugationResults.filter(cr => cr.conjugationResult.formulaNo === verbSelectionDetail.formula);
            if (selection && selection.length === 1) {
                transitiveState = selection[0].transitivity;
                this.verbDisplay = selection[0].display;
            }
        }
        else {
            if (verbSelectionDetail.isTri) {
                const selection = this.currentlySelectedRoot.unaugmentedRoots.filter(r => this.conjugationClassToNumber(r.root.conjugation) === verbSelectionDetail.conjugationClass)
                    .map(r => r.root.transitive);
                if (selection && selection.length === 1) {
                    transitiveState = selection[0];
                    this.verbDisplay = this.currentlySelectedRoot.unaugmentedRoots[0].display;
                }
            }
            else {
                const selection = this.currentlySelectedRoot.unaugmentedRoots;
                if (selection && selection.length === 1) {
                    transitiveState = selection[0].root.transitive;
                    this.verbDisplay = selection[0].display;
                }
            }
        }
        if (transitiveState) {
            this.transitivity = this.getTransitivityDescription(transitiveState);
        }
    }
    getTransitivityDescription(t) {
        switch (t) {
            case 'ك':
                return "متعد وﻻزم";
            case 'ل':
                return "ﻻزم";
            case 'م':
                return "متعد";
            default:
                break;
        }
        return "--";
    }
    processRootResult(rootResult) {
        if (rootResult == null) {
            return;
        }
        this.currentlySelectedRoot = rootResult;
        this.rootFormControl.setValue(rootResult.root);
        this.kindOfVerb = rootResult.kindOfVerb;
    }
    ngOnInit() {
        this.reset();
    }
    reset() {
        this.currentlySelectedRoot = null;
        this.kindOfVerb = "";
        this.transitivity = "";
        this.verbDisplay = "";
    }
    isTri() {
        return this.getRootType() === _root_type_enum__WEBPACK_IMPORTED_MODULE_0__.RootType.Tri;
    }
    search(event) {
        this.reset();
        const currentRoot = this.correctHamza(this.rootFormControl.value);
        if (currentRoot !== this.rootFormControl.value) {
            this.rootFormControl.setValue(currentRoot);
        }
        // tslint:disable-next-line:no-console
        console.debug(event);
        if (this.isTri()) {
            /* this is needed because we want to navigate sometimes from an existing search result (same route)*/
            this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
                this.router.navigate([`/tri/${currentRoot}`]);
            });
        }
        else {
            this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
                this.router.navigate([`/quad/${currentRoot}`]);
            });
        }
    }
    getRootType() {
        const currentRoot = this.rootFormControl.value;
        if (currentRoot == null || currentRoot.length === 0) {
            return _root_type_enum__WEBPACK_IMPORTED_MODULE_0__.RootType.None;
        }
        if (currentRoot.length === 3) {
            return _root_type_enum__WEBPACK_IMPORTED_MODULE_0__.RootType.Tri;
        }
        if (currentRoot.length === 4) {
            return _root_type_enum__WEBPACK_IMPORTED_MODULE_0__.RootType.Quad;
        }
        return _root_type_enum__WEBPACK_IMPORTED_MODULE_0__.RootType.None;
    }
    correctHamza(root) {
        if (root == null)
            return null;
        let newRoot = "";
        for (let i = 0; i < root.length; i++) {
            if (this.hamzaString.indexOf(root[i]) != -1) {
                newRoot += 'ء';
                continue;
            }
            newRoot += root[i];
        }
        return newRoot;
    }
    conjugationClassToNumber(cclass) {
        cclass = cclass.toLocaleLowerCase();
        switch (cclass) {
            case "first":
                return 1;
            case "second":
                return 2;
            case "third":
                return 3;
            case "forth":
                return 4;
            case "fifth":
                return 5;
            case "sixth":
                return 6;
        }
        return 0;
    }
    ngOnDestroy() {
        var _a, _b, _c;
        (_a = this.verbSelectedSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
        (_b = this.rootResultSubscription) === null || _b === void 0 ? void 0 : _b.unsubscribe();
        (_c = this.sarfServiceSubscription) === null || _c === void 0 ? void 0 : _c.unsubscribe();
    }
}
RootsearchComponent.ɵfac = function RootsearchComponent_Factory(t) { return new (t || RootsearchComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_1__.AppNotificationsService), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_2__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__.Router)); };
RootsearchComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵdefineComponent"]({ type: RootsearchComponent, selectors: [["app-rootsearch"]], decls: 22, vars: 8, consts: [[1, "root-search-form", 3, "ngSubmit"], [1, "form-fields-container", "containerX"], ["fxLayout", "row", "fxLayoutAlign", "left center"], ["appearance", "fill", "fxFlex", ""], ["matInput", "", "placeholder", "\u0623\u062F\u062E\u0644 \u062C\u0630\u0631\u0627\u064B \u062B\u0644\u0627\u062B\u064A\u0627\u064B \u0623\u0648 \u0631\u0628\u0627\u0639\u064A\u0627\u064B (\u0628\u062F\u0621\u060C \u0645\u062B\u0644\u0627\u064B)", "maxlength", "4", "lang", "ar", "minlength", "3", "dir", "rtl", 2, "font-size", "x-large", 3, "formControl", "errorStateMatcher"], [4, "ngIf"], ["mat-raised-button", "", "type", "submit", 1, "search-button"], ["title", "\u0625\u0628\u062D\u062B"], ["matInput", "", "placeholder", "", "lang", "ar", "dir", "rtl", "disabled", "disabled", 2, "color", "blue", 3, "value"], ["mat-button", "", "disabled", "disabled", 2, "font-size", "1.5em"], ["mat-button", "", "disabled", "disabled", 2, "font-size", "large"]], template: function RootsearchComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](0, "form", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵlistener"]("ngSubmit", function RootsearchComponent_Template_form_ngSubmit_0_listener($event) { return ctx.search($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](3, "mat-form-field", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](4, "input", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](5, RootsearchComponent_mat_error_5_Template, 3, 0, "mat-error", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtemplate"](6, RootsearchComponent_mat_error_6_Template, 5, 0, "mat-error", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](7, "button", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](8, "mat-icon", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](9, "search");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](10, "mat-form-field", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](11, "input", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](12, "button", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](13);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](14, "mat-form-field", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](15, "input", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](16, "button", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](17, "\u0646\u0648\u0639 \u0627\u0644\u0641\u0639\u0644 \u0627\u0644\u0645\u062C\u0631\u062F");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](18, "mat-form-field", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelement"](19, "input", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementStart"](20, "button", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtext"](21, "\u0627\u0644\u062A\u0639\u062F\u064A \u0648 \u0627\u0644\u0644\u0632\u0648\u0645");
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("formControl", ctx.rootFormControl)("errorStateMatcher", ctx.matcher);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", !ctx.rootFormControl.hasError("required"));
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵproperty"]("ngIf", ctx.rootFormControl.hasError("required"));
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpropertyInterpolate"]("value", ctx.verbDisplay);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵtextInterpolate"](ctx.verbDisplay);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpropertyInterpolate"]("value", ctx.kindOfVerb);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_3__["ɵɵpropertyInterpolate"]("value", ctx.transitivity);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_4__["ɵNgNoValidate"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__.NgControlStatusGroup, _angular_forms__WEBPACK_IMPORTED_MODULE_4__.NgForm, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_6__.DefaultLayoutDirective, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_6__.DefaultLayoutAlignDirective, _angular_material_form_field__WEBPACK_IMPORTED_MODULE_7__.MatFormField, _angular_flex_layout_flex__WEBPACK_IMPORTED_MODULE_6__.DefaultFlexDirective, _angular_material_input__WEBPACK_IMPORTED_MODULE_8__.MatInput, _angular_forms__WEBPACK_IMPORTED_MODULE_4__.DefaultValueAccessor, _angular_forms__WEBPACK_IMPORTED_MODULE_4__.MaxLengthValidator, _angular_forms__WEBPACK_IMPORTED_MODULE_4__.MinLengthValidator, _angular_cdk_bidi__WEBPACK_IMPORTED_MODULE_9__.Dir, _angular_forms__WEBPACK_IMPORTED_MODULE_4__.NgControlStatus, _angular_forms__WEBPACK_IMPORTED_MODULE_4__.FormControlDirective, _angular_common__WEBPACK_IMPORTED_MODULE_10__.NgIf, _angular_material_button__WEBPACK_IMPORTED_MODULE_11__.MatButton, _angular_material_icon__WEBPACK_IMPORTED_MODULE_12__.MatIcon, _angular_material_form_field__WEBPACK_IMPORTED_MODULE_7__.MatError], styles: [".root-search-form[_ngcontent-%COMP%] {\r\n    margin-bottom: -1px;\r\n    font-family: Kitab, system-ui;\r\n  }\r\n\r\n  .mat-form-field[_ngcontent-%COMP%] {\r\n    font-family: Kitab, system-ui;\r\n    width: 100%;\r\n  }\r\n\r\n  button[_ngcontent-%COMP%]\r\n  {\r\n    font-family: Kitab, system-ui; \r\n  }\r\n\r\n  .search-button[_ngcontent-%COMP%]\r\n  {\r\n    vertical-align: middle;\r\n    float:left;\r\n  }\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInJvb3RzZWFyY2guY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7SUFDSSxtQkFBbUI7SUFDbkIsNkJBQTZCO0VBQy9COztFQUVBO0lBQ0UsNkJBQTZCO0lBQzdCLFdBQVc7RUFDYjs7RUFFQTs7SUFFRSw2QkFBNkI7RUFDL0I7O0VBRUE7O0lBRUUsc0JBQXNCO0lBQ3RCLFVBQVU7RUFDWiIsImZpbGUiOiJyb290c2VhcmNoLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuLnJvb3Qtc2VhcmNoLWZvcm0ge1xyXG4gICAgbWFyZ2luLWJvdHRvbTogLTFweDtcclxuICAgIGZvbnQtZmFtaWx5OiBLaXRhYiwgc3lzdGVtLXVpO1xyXG4gIH1cclxuXHJcbiAgLm1hdC1mb3JtLWZpZWxkIHtcclxuICAgIGZvbnQtZmFtaWx5OiBLaXRhYiwgc3lzdGVtLXVpO1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgfVxyXG5cclxuICBidXR0b25cclxuICB7XHJcbiAgICBmb250LWZhbWlseTogS2l0YWIsIHN5c3RlbS11aTsgXHJcbiAgfVxyXG5cclxuICAuc2VhcmNoLWJ1dHRvblxyXG4gIHtcclxuICAgIHZlcnRpY2FsLWFsaWduOiBtaWRkbGU7XHJcbiAgICBmbG9hdDpsZWZ0O1xyXG4gIH0iXX0= */"] });


/***/ }),

/***/ 3157:
/*!********************************************************************!*\
  !*** ./src/app/sarf-verb-pronouns/sarf-verb-pronouns.component.ts ***!
  \********************************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "SarfVerbPronounsComponent": function() { return /* binding */ SarfVerbPronounsComponent; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);

class SarfVerbPronounsComponent {
    constructor() {
        this.verbs = Array(13);
        for (var i = 0; i < 13; i++) {
            this.verbs[i] = "-";
        }
    }
    ngOnInit() {
    }
}
SarfVerbPronounsComponent.ɵfac = function SarfVerbPronounsComponent_Factory(t) { return new (t || SarfVerbPronounsComponent)(); };
SarfVerbPronounsComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: SarfVerbPronounsComponent, selectors: [["app-sarf-verb-pronouns"]], inputs: { verbs: "verbs" }, decls: 65, vars: 13, consts: [[1, "mainContainer"], [1, "column"], [1, "pcolumn"], [1, "pronoun"], [1, "vcolumn"], [1, "verb"]], template: function SarfVerbPronounsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "\u0623\u0646\u0627");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\u0646\u062D\u0646");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\u0623\u0646\u062A\u064E");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "\u0623\u0646\u062A\u0650");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "\u0623\u0646\u062A\u0645\u0627");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "\u0623\u0646\u062A\u0645");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "\u0623\u0646\u062A\u0646\u0651\u064E");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](29);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](35, "\u0647\u0648");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](37, "\u0647\u064A");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](38, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](39, " \u0647\u0645\u0627");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "sub");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "em");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](42, "(\u0645\u0630)");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](43, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](44, " \u0647\u0645\u0627");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](45, "sub");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](46, "em");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](47, "(\u0645\u0624)");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](48, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](49, "\u0647\u0645");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](50, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](51, "\u0647\u0646\u0651\u064E");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](52, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](53, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](54);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](55, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](56);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](57, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](58);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](59, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](60);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](61, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](62);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](63, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](64);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[0]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[1]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[2]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[3]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[4]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[5]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[6]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[7]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[8]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[9]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[10]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[11]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.verbs[12]);
    } }, styles: [".mainContainer[_ngcontent-%COMP%]{\n    margin-top: 10px;\n    display: flex;\n    flex-direction: row;\n    align-items: stretch;\n\n}\n\n.column[_ngcontent-%COMP%] {\n    display: flex;\n    flex-direction: row;\n    flex: 1 10%;\n    align-items: stretch;\n\n}\n\n.pcolumn[_ngcontent-%COMP%] {\n    padding: 5px;\n    margin: 1px;\n    display: flex;\n    flex-direction: column;\n    background-color: wheat;\n    flex: 1 10%;\n    text-align: center;\n    align-content: center;\n    vertical-align: middle;\n    align-items: flex-end;\n    border-style: solid;\n    border-radius: 2px;\n    border-width: 1px 0px 1px 1px;\n    border-color: slategray;\n}\n\n.vcolumn[_ngcontent-%COMP%] {\n    padding: 5px;\n    margin: 1px;\n    display: flex;\n    flex-direction: column;\n    background-color: blanchedalmond;\n    flex: 1 90%;\n    fill-rule: evenodd;\n    text-align: center;\n    align-content: center;\n    vertical-align: middle;\n    align-items: flex-start;\n    border-style: solid;\n    border-radius: 2px;\n    border-width: 1px 0px 1px 1px;\n    border-color: slategray;\n}\n\n.pronoun[_ngcontent-%COMP%] {\n    display: flex;\n    font-size: xx-large;    \n    border-style: solid;\n    border-radius: 2px;\n    border-width: 0px 0px 1px 0px;\n    border-color: slategray;\n}\n\n.verb[_ngcontent-%COMP%] {\n    display: flex;\n    font-size: xx-large;\n    border-style: solid;\n    border-radius: 2px;\n    border-width: 0px 0px 1px 0px;\n    border-color: slategray;\n}\n\nsub[_ngcontent-%COMP%] {\n    font-size: 0.5em;\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNhcmYtdmVyYi1wcm9ub3Vucy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0lBQ0ksZ0JBQWdCO0lBQ2hCLGFBQWE7SUFDYixtQkFBbUI7SUFDbkIsb0JBQW9COztBQUV4Qjs7QUFFQTtJQUNJLGFBQWE7SUFDYixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLG9CQUFvQjs7QUFFeEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLGFBQWE7SUFDYixzQkFBc0I7SUFDdEIsdUJBQXVCO0lBQ3ZCLFdBQVc7SUFDWCxrQkFBa0I7SUFDbEIscUJBQXFCO0lBQ3JCLHNCQUFzQjtJQUN0QixxQkFBcUI7SUFDckIsbUJBQW1CO0lBQ25CLGtCQUFrQjtJQUNsQiw2QkFBNkI7SUFDN0IsdUJBQXVCO0FBQzNCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLFdBQVc7SUFDWCxhQUFhO0lBQ2Isc0JBQXNCO0lBQ3RCLGdDQUFnQztJQUNoQyxXQUFXO0lBQ1gsa0JBQWtCO0lBQ2xCLGtCQUFrQjtJQUNsQixxQkFBcUI7SUFDckIsc0JBQXNCO0lBQ3RCLHVCQUF1QjtJQUN2QixtQkFBbUI7SUFDbkIsa0JBQWtCO0lBQ2xCLDZCQUE2QjtJQUM3Qix1QkFBdUI7QUFDM0I7O0FBRUE7SUFDSSxhQUFhO0lBQ2IsbUJBQW1CO0lBQ25CLG1CQUFtQjtJQUNuQixrQkFBa0I7SUFDbEIsNkJBQTZCO0lBQzdCLHVCQUF1QjtBQUMzQjs7QUFDQTtJQUNJLGFBQWE7SUFDYixtQkFBbUI7SUFDbkIsbUJBQW1CO0lBQ25CLGtCQUFrQjtJQUNsQiw2QkFBNkI7SUFDN0IsdUJBQXVCO0FBQzNCOztBQUVBO0lBQ0ksZ0JBQWdCO0FBQ3BCIiwiZmlsZSI6InNhcmYtdmVyYi1wcm9ub3Vucy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLm1haW5Db250YWluZXJ7XG4gICAgbWFyZ2luLXRvcDogMTBweDtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZsZXgtZGlyZWN0aW9uOiByb3c7XG4gICAgYWxpZ24taXRlbXM6IHN0cmV0Y2g7XG5cbn1cblxuLmNvbHVtbiB7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBmbGV4LWRpcmVjdGlvbjogcm93O1xuICAgIGZsZXg6IDEgMTAlO1xuICAgIGFsaWduLWl0ZW1zOiBzdHJldGNoO1xuXG59XG5cbi5wY29sdW1uIHtcbiAgICBwYWRkaW5nOiA1cHg7XG4gICAgbWFyZ2luOiAxcHg7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICAgIGJhY2tncm91bmQtY29sb3I6IHdoZWF0O1xuICAgIGZsZXg6IDEgMTAlO1xuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgICBhbGlnbi1jb250ZW50OiBjZW50ZXI7XG4gICAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcbiAgICBhbGlnbi1pdGVtczogZmxleC1lbmQ7XG4gICAgYm9yZGVyLXN0eWxlOiBzb2xpZDtcbiAgICBib3JkZXItcmFkaXVzOiAycHg7XG4gICAgYm9yZGVyLXdpZHRoOiAxcHggMHB4IDFweCAxcHg7XG4gICAgYm9yZGVyLWNvbG9yOiBzbGF0ZWdyYXk7XG59XG5cbi52Y29sdW1uIHtcbiAgICBwYWRkaW5nOiA1cHg7XG4gICAgbWFyZ2luOiAxcHg7XG4gICAgZGlzcGxheTogZmxleDtcbiAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICAgIGJhY2tncm91bmQtY29sb3I6IGJsYW5jaGVkYWxtb25kO1xuICAgIGZsZXg6IDEgOTAlO1xuICAgIGZpbGwtcnVsZTogZXZlbm9kZDtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gICAgYWxpZ24tY29udGVudDogY2VudGVyO1xuICAgIHZlcnRpY2FsLWFsaWduOiBtaWRkbGU7XG4gICAgYWxpZ24taXRlbXM6IGZsZXgtc3RhcnQ7XG4gICAgYm9yZGVyLXN0eWxlOiBzb2xpZDtcbiAgICBib3JkZXItcmFkaXVzOiAycHg7XG4gICAgYm9yZGVyLXdpZHRoOiAxcHggMHB4IDFweCAxcHg7XG4gICAgYm9yZGVyLWNvbG9yOiBzbGF0ZWdyYXk7XG59XG5cbi5wcm9ub3VuIHtcbiAgICBkaXNwbGF5OiBmbGV4O1xuICAgIGZvbnQtc2l6ZTogeHgtbGFyZ2U7ICAgIFxuICAgIGJvcmRlci1zdHlsZTogc29saWQ7XG4gICAgYm9yZGVyLXJhZGl1czogMnB4O1xuICAgIGJvcmRlci13aWR0aDogMHB4IDBweCAxcHggMHB4O1xuICAgIGJvcmRlci1jb2xvcjogc2xhdGVncmF5O1xufVxuLnZlcmIge1xuICAgIGRpc3BsYXk6IGZsZXg7XG4gICAgZm9udC1zaXplOiB4eC1sYXJnZTtcbiAgICBib3JkZXItc3R5bGU6IHNvbGlkO1xuICAgIGJvcmRlci1yYWRpdXM6IDJweDtcbiAgICBib3JkZXItd2lkdGg6IDBweCAwcHggMXB4IDBweDtcbiAgICBib3JkZXItY29sb3I6IHNsYXRlZ3JheTtcbn1cblxuc3ViIHtcbiAgICBmb250LXNpemU6IDAuNWVtO1xufSJdfQ== */"] });


/***/ }),

/***/ 3096:
/*!*******************************************************!*\
  !*** ./src/app/services/app-notifications.service.ts ***!
  \*******************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "AppNotificationsService": function() { return /* binding */ AppNotificationsService; }
/* harmony export */ });
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! rxjs */ 9441);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ 2316);


class AppNotificationsService {
    constructor() {
        this.rootResultSource = new rxjs__WEBPACK_IMPORTED_MODULE_0__.Subject();
        this.verbSelectedSource = new rxjs__WEBPACK_IMPORTED_MODULE_0__.Subject();
        this.rootResultRetrieved$ = this.rootResultSource.asObservable();
        this.verbSelected$ = this.verbSelectedSource.asObservable();
    }
    broadcastRootResult(rootResult) {
        this.rootResultSource.next(rootResult);
    }
    broadcastVerbSelected(verb) {
        this.verbSelectedSource.next(verb);
    }
}
AppNotificationsService.ɵfac = function AppNotificationsService_Factory(t) { return new (t || AppNotificationsService)(); };
AppNotificationsService.ɵprov = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjectable"]({ token: AppNotificationsService, factory: AppNotificationsService.ɵfac, providedIn: 'root' });


/***/ }),

/***/ 4029:
/*!******************************************!*\
  !*** ./src/app/services/sarf-service.ts ***!
  \******************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "SarfService": function() { return /* binding */ SarfService; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ 3882);


class SarfService {
    constructor(httpClient) {
        this.httpClient = httpClient;
    }
    findSarf(root) {
        console.info('searching for ' + root);
        return this.httpClient.get('/sarf/' + encodeURIComponent(root));
    }
    getActiveVerbConjugatons(verbSelectionDetail) {
        console.info(`active verb conjugations for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
        return this.httpClient.get(`/sarf/active/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
    }
    getPassiveVerbConjugatons(verbSelectionDetail) {
        console.info(`passive verb conjugations for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
        return this.httpClient.get(`/sarf/passive/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
    }
    getDerivedNouns(verbSelectionDetail) {
        console.info(`derived nouns for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
        return this.httpClient.get(`/sarf/nouns/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
    }
    getGerunds(verbSelectionDetail) {
        console.info(`gerunds for ${verbSelectionDetail.verb} class: ${verbSelectionDetail.conjugationClass} formula: ${verbSelectionDetail.formula} augmented: ${verbSelectionDetail.isAugmented}`);
        return this.httpClient.get(`/sarf/gerunds/${encodeURIComponent(verbSelectionDetail.verb)}?augmented=${verbSelectionDetail.isAugmented}&cclass=${verbSelectionDetail.conjugationClass}&formula=${verbSelectionDetail.formula}`);
    }
}
SarfService.ɵfac = function SarfService_Factory(t) { return new (t || SarfService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__.HttpClient)); };
SarfService.ɵprov = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: SarfService, factory: SarfService.ɵfac, providedIn: 'root' });


/***/ }),

/***/ 5246:
/*!******************************************!*\
  !*** ./src/app/start/start.component.ts ***!
  \******************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "StartComponent": function() { return /* binding */ StartComponent; }
/* harmony export */ });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ 2316);

class StartComponent {
    constructor() { }
    ngOnInit() {
    }
}
StartComponent.ɵfac = function StartComponent_Factory(t) { return new (t || StartComponent)(); };
StartComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: StartComponent, selectors: [["app-start"]], decls: 1, vars: 0, consts: [[2, "display", "none"]], template: function StartComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "div", 0);
    } }, styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzdGFydC5jb21wb25lbnQuY3NzIn0= */"] });


/***/ }),

/***/ 3932:
/*!****************************************************************************************!*\
  !*** ./src/app/trilateral-conjugation-panel/trilateral-conjugation-panel.component.ts ***!
  \****************************************************************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "TrilateralConjugationPanelComponent": function() { return /* binding */ TrilateralConjugationPanelComponent; }
/* harmony export */ });
/* harmony import */ var _models_trilateral_conjugation_group__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../models/trilateral-conjugation-group */ 9828);
/* harmony import */ var _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../models/conjugationgroup */ 1185);
/* harmony import */ var _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../models/conjugationclass */ 1348);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _services_sarf_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/sarf-service */ 4029);
/* harmony import */ var _services_app_notifications_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/app-notifications.service */ 3096);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ 1258);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common */ 4364);
/* harmony import */ var _conjugation_group_conjugation_group_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../conjugation-group/conjugation-group.component */ 40);
/* harmony import */ var _angular_material_list__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/list */ 8417);
/* harmony import */ var _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../not-found/not-found.component */ 1142);











function TrilateralConjugationPanelComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "div");
} }
function TrilateralConjugationPanelComponent_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "app-conjugation-group", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](1, "app-conjugation-group", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](2, "app-conjugation-group", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](3, "app-conjugation-group", 3);
} if (rf & 2) {
    const ctx_r2 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.unaugmented);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.augmentedByOne);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.augmentedByTwo);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("conjugationGroup", ctx_r2.conjugationGroup == null ? null : ctx_r2.conjugationGroup.augmentedByThree);
} }
function TrilateralConjugationPanelComponent_ng_template_3_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "div");
} }
function TrilateralConjugationPanelComponent_ng_template_3_ng_template_1_mat_list_item_3_Template(rf, ctx) { if (rf & 1) {
    const _r13 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "mat-list-item");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](1, "a", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵlistener"]("click", function TrilateralConjugationPanelComponent_ng_template_3_ng_template_1_mat_list_item_3_Template_a_click_1_listener() { const restoredCtx = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵrestoreView"](_r13); const alternative_r11 = restoredCtx.$implicit; const ctx_r12 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"](3); return ctx_r12.navigatTo(alternative_r11.path); });
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
} if (rf & 2) {
    const alternative_r11 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtextInterpolate"](alternative_r11.display);
} }
function TrilateralConjugationPanelComponent_ng_template_3_ng_template_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](0, "p");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtext"](1, "\u064A\u0648\u062C\u062F \u0623\u0643\u062B\u0631 \u0645\u0646 \u062C\u0630\u0631. \u0625\u062E\u062A\u0631 \u0623\u062D\u062F \u0627\u0644\u062C\u0630\u0631\u064A\u0646");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementStart"](2, "mat-nav-list");
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](3, TrilateralConjugationPanelComponent_ng_template_3_ng_template_1_mat_list_item_3_Template, 3, 1, "mat-list-item", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngForOf", ctx_r7.alternatives);
} }
function TrilateralConjugationPanelComponent_ng_template_3_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵelement"](0, "app-not-found");
} }
function TrilateralConjugationPanelComponent_ng_template_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](0, TrilateralConjugationPanelComponent_ng_template_3_div_0_Template, 1, 0, "div", 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](1, TrilateralConjugationPanelComponent_ng_template_3_ng_template_1_Template, 4, 1, "ng-template", null, 4, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](3, TrilateralConjugationPanelComponent_ng_template_3_ng_template_3_Template, 1, 0, "ng-template", null, 5, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
} if (rf & 2) {
    const _r6 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](2);
    const _r8 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](4);
    const ctx_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx_r4.hasAlternatives())("ngIfThen", _r6)("ngIfElse", _r8);
} }
class TrilateralConjugationPanelComponent {
    constructor(sarfService, appNotificationsService, route, router) {
        this.sarfService = sarfService;
        this.appNotificationsService = appNotificationsService;
        this.route = route;
        this.router = router;
    }
    ngOnInit() {
        const currentRoot = this.resetSearch();
        this.serviceSubscription = this.sarfService.findSarf(currentRoot).subscribe(rootResult => {
            console.log(rootResult);
            this.processTriResult(rootResult);
        }, n => console.log(n));
    }
    resetSearch() {
        const currentRoot = this.route.snapshot.paramMap.get('root');
        this.conjugationGroup = null;
        this.alternatives = null;
        return currentRoot;
    }
    hasSingleResult() {
        return this.conjugationGroup != null;
    }
    hasAlternatives() {
        return this.alternatives != null && this.alternatives.length > 1;
    }
    navigatTo(path) {
        this.router.navigateByUrl('/', { skipLocationChange: true })
            .then(() => this.router.navigate([path]));
    }
    processTriResult(rootResult) {
        if (rootResult == null || rootResult.length == 0) {
            return;
        }
        if (rootResult.length > 1) {
            this.alternatives = rootResult.map(root => ({
                "path": `/tri/${root.root}`,
                "display": root.root
            }));
            return;
        }
        const result = rootResult[0];
        const root = result.root;
        const unaugmented = this.buildUnaugmentedConjugationClasses(result.unaugmentedRoots, root);
        const augmentedByOne = this.buildAugmentedByOneConjugationClasses(result.conjugationResults, root);
        const augmentedByTwo = this.buildAugmentedByTwoConjugationClasses(result.conjugationResults, root);
        const augmentedByThreeOrMore = this.buildAugmentedByThreeConjugationClasses(result.conjugationResults, root);
        this.conjugationGroup = new _models_trilateral_conjugation_group__WEBPACK_IMPORTED_MODULE_0__.TrilateralConjugationGroup(unaugmented, augmentedByOne, augmentedByTwo, augmentedByThreeOrMore);
        this.appNotificationsService.broadcastRootResult(result);
    }
    buildUnaugmentedConjugationClasses(unaugmentedRoots, root) {
        if (!unaugmentedRoots) {
            return;
        }
        const first = this.getTriUnaugmentedRootText(unaugmentedRoots, "First");
        const second = this.getTriUnaugmentedRootText(unaugmentedRoots, "Second");
        const third = this.getTriUnaugmentedRootText(unaugmentedRoots, "Third");
        const forth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Forth");
        const fifth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Fifth");
        const sixth = this.getTriUnaugmentedRootText(unaugmentedRoots, "Sixth");
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.UnaugmentedTriConjugationClass(1, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriFirstConjugationClass, first, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.UnaugmentedTriConjugationClass(2, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriSecondConjugationClass, second, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.UnaugmentedTriConjugationClass(3, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriThirdConjugationClass, third, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.UnaugmentedTriConjugationClass(4, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriForthConjugationClass, forth, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.UnaugmentedTriConjugationClass(5, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriFifthConjugationClass, fifth, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.UnaugmentedTriConjugationClass(6, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriSixthConjugationClass, sixth, root)
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.TriUnaugmentedLabel, conjugationClasses);
    }
    getTriUnaugmentedRootText(unaugmentedRoots, conjugationclass) {
        return unaugmentedRoots.filter(r => r.root.conjugation === conjugationclass)
            .map(r => r.display)
            .join('');
    }
    buildAugmentedByOneConjugationClasses(conjugationResults, root) {
        var formula1 = this.getTriAugmentedRootText(conjugationResults, 1);
        var formula2 = this.getTriAugmentedRootText(conjugationResults, 2);
        var formula3 = this.getTriAugmentedRootText(conjugationResults, 3);
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(1, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByOneFirstConjugationClass, formula1, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(2, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByOneSecondConjugationClass, formula2, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(3, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByOneThirdConjugationClass, formula3, root)
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.TriAugmentedByOneLabel, conjugationClasses);
    }
    buildAugmentedByTwoConjugationClasses(conjugationResults, root) {
        var formula4 = this.getTriAugmentedRootText(conjugationResults, 4);
        var formula5 = this.getTriAugmentedRootText(conjugationResults, 5);
        var formula6 = this.getTriAugmentedRootText(conjugationResults, 6);
        var formula7 = this.getTriAugmentedRootText(conjugationResults, 7);
        var formula8 = this.getTriAugmentedRootText(conjugationResults, 8);
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(4, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByTwoFirstConjugationClass, formula4, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(5, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByTwoSecondConjugationClass, formula5, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(6, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByTwoThirdConjugationClass, formula6, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(7, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByTwoForthConjugationClass, formula7, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(8, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByTwoFifthConjugationClass, formula8, root)
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.TriAugmentedByTwoLabel, conjugationClasses);
    }
    buildAugmentedByThreeConjugationClasses(conjugationResults, root) {
        var formula9 = this.getTriAugmentedRootText(conjugationResults, 9);
        var formula10 = this.getTriAugmentedRootText(conjugationResults, 10);
        var formula11 = this.getTriAugmentedRootText(conjugationResults, 11);
        var formula12 = this.getTriAugmentedRootText(conjugationResults, 12);
        const conjugationClasses = [
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(9, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByThreeFirstConjugationClass, formula9, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(10, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByThreeSecConjugationClass, formula10, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(11, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByThreeThirdConjugationClass, formula11, root),
            new _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.AugmentedTriConjugationClass(12, _models_conjugationclass__WEBPACK_IMPORTED_MODULE_2__.ConjugationClassStatic.TriAugmentedByThreeForthConjugationClass, formula12, root)
        ];
        return new _models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup(_models_conjugationgroup__WEBPACK_IMPORTED_MODULE_1__.ConjugationGroup.TriAugmentedByThreeLabel, conjugationClasses);
    }
    getTriAugmentedRootText(conjugationResults, formulaNo) {
        return conjugationResults.filter(r => r.conjugationResult.formulaNo === formulaNo)
            .map(r => r.display)
            .join('');
    }
    ngOnDestroy() {
        var _a;
        (_a = this.serviceSubscription) === null || _a === void 0 ? void 0 : _a.unsubscribe();
    }
}
TrilateralConjugationPanelComponent.ɵfac = function TrilateralConjugationPanelComponent_Factory(t) { return new (t || TrilateralConjugationPanelComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_services_sarf_service__WEBPACK_IMPORTED_MODULE_3__.SarfService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_services_app_notifications_service__WEBPACK_IMPORTED_MODULE_4__.AppNotificationsService), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.ActivatedRoute), _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_8__.Router)); };
TrilateralConjugationPanelComponent.ɵcmp = /*@__PURE__*/ _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵdefineComponent"]({ type: TrilateralConjugationPanelComponent, selectors: [["app-trilateral-conjugation-panel"]], decls: 5, vars: 3, consts: [[4, "ngIf", "ngIfThen", "ngIfElse"], ["resultBlock", ""], ["emptyBlock", ""], [3, "conjugationGroup"], ["alternativesBlock", ""], ["notFoundBlock", ""], [4, "ngFor", "ngForOf"], [3, "click"]], template: function TrilateralConjugationPanelComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](0, TrilateralConjugationPanelComponent_div_0_Template, 1, 0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](1, TrilateralConjugationPanelComponent_ng_template_1_Template, 4, 4, "ng-template", null, 1, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplate"](3, TrilateralConjugationPanelComponent_ng_template_3_Template, 5, 3, "ng-template", null, 2, _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵtemplateRefExtractor"]);
    } if (rf & 2) {
        const _r1 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](2);
        const _r3 = _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵreference"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_7__["ɵɵproperty"]("ngIf", ctx.hasSingleResult())("ngIfThen", _r1)("ngIfElse", _r3);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_9__.NgIf, _conjugation_group_conjugation_group_component__WEBPACK_IMPORTED_MODULE_5__.ConjugationGroupComponent, _angular_material_list__WEBPACK_IMPORTED_MODULE_10__.MatNavList, _angular_common__WEBPACK_IMPORTED_MODULE_9__.NgForOf, _angular_material_list__WEBPACK_IMPORTED_MODULE_10__.MatListItem, _not_found_not_found_component__WEBPACK_IMPORTED_MODULE_6__.NotFoundComponent], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJ0cmlsYXRlcmFsLWNvbmp1Z2F0aW9uLXBhbmVsLmNvbXBvbmVudC5jc3MifQ== */"] });


/***/ }),

/***/ 2340:
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "environment": function() { return /* binding */ environment; }
/* harmony export */ });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
const environment = {
    production: false,
    apiUrl: 'http://localhost:8080'
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ 4431:
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/***/ (function(__unused_webpack_module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ 1570);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ 2316);
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./app/app.module */ 6747);
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./environments/environment */ 2340);




if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__.environment.production) {
    (0,_angular_core__WEBPACK_IMPORTED_MODULE_2__.enableProdMode)();
}
_angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__.platformBrowser().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_0__.AppModule)
    .catch(err => console.error(err));


/***/ })

},
/******/ function(__webpack_require__) { // webpackRuntimeModules
/******/ var __webpack_exec__ = function(moduleId) { return __webpack_require__(__webpack_require__.s = moduleId); }
/******/ __webpack_require__.O(0, ["vendor"], function() { return __webpack_exec__(4431); });
/******/ var __webpack_exports__ = __webpack_require__.O();
/******/ }
]);
//# sourceMappingURL=main-es2015.js.map