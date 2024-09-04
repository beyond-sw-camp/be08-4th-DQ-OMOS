import{B as s,e as g,o as e,j as r,l as i,m as t,p as l,q as c,y as d,k as p,t as u}from"./index-BaXTvT8w.js";var y=function(o){var n=o.dt;return`
.p-tag {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    background: `.concat(n("tag.primary.background"),`;
    color: `).concat(n("tag.primary.color"),`;
    font-size: `).concat(n("tag.font.size"),`;
    font-weight: `).concat(n("tag.font.weight"),`;
    padding: `).concat(n("tag.padding"),`;
    border-radius: `).concat(n("tag.border.radius"),`;
    gap: `).concat(n("tag.gap"),`;
}

.p-tag-icon {
    font-size: `).concat(n("tag.icon.size"),`;
    width: `).concat(n("tag.icon.size"),`;
    height:`).concat(n("tag.icon.size"),`;
}

.p-tag-rounded {
    border-radius: `).concat(n("tag.rounded.border.radius"),`;
}

.p-tag-success {
    background: `).concat(n("tag.success.background"),`;
    color: `).concat(n("tag.success.color"),`;
}

.p-tag-info {
    background: `).concat(n("tag.info.background"),`;
    color: `).concat(n("tag.info.color"),`;
}

.p-tag-warn {
    background: `).concat(n("tag.warn.background"),`;
    color: `).concat(n("tag.warn.color"),`;
}

.p-tag-danger {
    background: `).concat(n("tag.danger.background"),`;
    color: `).concat(n("tag.danger.color"),`;
}

.p-tag-secondary {
    background: `).concat(n("tag.secondary.background"),`;
    color: `).concat(n("tag.secondary.color"),`;
}

.p-tag-contrast {
    background: `).concat(n("tag.contrast.background"),`;
    color: `).concat(n("tag.contrast.color"),`;
}
`)},m={root:function(o){var n=o.props;return["p-tag p-component",{"p-tag-info":n.severity==="info","p-tag-success":n.severity==="success","p-tag-warn":n.severity==="warn","p-tag-danger":n.severity==="danger","p-tag-secondary":n.severity==="secondary","p-tag-contrast":n.severity==="contrast","p-tag-rounded":n.rounded}]},icon:"p-tag-icon",label:"p-tag-label"},b=s.extend({name:"tag",theme:y,classes:m}),f={name:"BaseTag",extends:g,props:{value:null,severity:null,rounded:Boolean,icon:String},style:b,provide:function(){return{$pcTag:this,$parentInstance:this}}},k={name:"Tag",extends:f,inheritAttrs:!1};function v(a,o,n,h,$,w){return e(),r("span",t({class:a.cx("root")},a.ptmi("root")),[a.$slots.icon?(e(),i(l(a.$slots.icon),t({key:0,class:a.cx("icon")},a.ptm("icon")),null,16,["class"])):a.icon?(e(),r("span",t({key:1,class:[a.cx("icon"),a.icon]},a.ptm("icon")),null,16)):c("",!0),a.value!=null||a.$slots.default?d(a.$slots,"default",{key:2},function(){return[p("span",t({class:a.cx("label")},a.ptm("label")),u(a.value),17)]}):c("",!0)],16)}k.render=v;export{k as s};
