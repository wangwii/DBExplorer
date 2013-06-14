//=============================================================
var tabPanelTitle = "创建表-" + tableName;
var tab = false;
for (var i = 1; i < 1000; i++) {
	var tabPanelTitleTemp = tabPanelTitle + i;
	tab = tabPanel.getItem(tabPanelTitleTemp);
	if (!tab) {
		tabPanelTitle = tabPanelTitleTemp;
		tableName = tableName + i;
		break;
	}
}

// create CreateTablePanel
var node = dbtree.getSelectNode();
var nodes = node.getPath('text').split("/");
var panel = new DBE.TableInfoPanel({
	isCreate : true,
	databaseName : nodes[1],
	schemaName : nodes[2],
	tableName : tableName
});
var ctl = tabPanel.add({
	id : tabPanelTitle,
	title : tabPanelTitle,
	autoScroll : true,
	closable : true,
	plain : true,
	items : panel
})
ctl.show();
//=====================================================================
// 根据当前列类型信息 处理长度问题..
if ((fieldName == "datatype")) {
	// alert("reset.dl:" + eventObj.record.get("datatype"));
	// alert("type.info::" + eventObj.record.typeInfo);
	var typeInfo = eventObj.record.typeInfo;
	if (typeInfo) {
		if (typeInfo.resetLength) {
			eventObj.record.set("datalength", "70");
		} else {
			eventObj.record.set("datalength", "");
		}
	}
} else if (fieldName == "datalength") {
	var typeInfo = eventObj.record.typeInfo;
	if (typeInfo) {
		if (typeInfo.resetLength) {
			eventObj.record.set("datalength", "70");
		} else {
			eventObj.record.set("datalength", "");
		}
	}
}