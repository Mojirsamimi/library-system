function handleTableDoubleClick(event){
var table = event.getSource();
AdfCustomEvent.queue(table, "TableDoubleClickEvent",{}, true);
event.cancel();
}