### 1. 订单逆向单状态变更后更新上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderUpdateAfterReverseStatusChangeContext**



``` OrderUpdateAfterReverseStatusChangeContext ```

>订单逆向单状态变更后更新上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
reverseType|否|``` String ```|逆向单类型|-
reverseStatus|否|``` String ```|逆向单状态|-
originStatus|否|``` String ```|初始状态|-
exception|否|``` Boolean ```|是否收货异常订单|-
orderLines|否|``` List<OrderLine> ```|这次逆向操作涉及的订单行信息|-
alreadyRefundQuantityByOrderLineId|否|``` Map<Long,Integer> ```|订单行id和已经退款数量的对应关系|-
packageOrderLines|否|``` List<PackageOrderLine> ```|这次逆向操作涉及的包裹子单, 当逆向消息为收货异常需要用这个接口|-
packageOrders|否|``` List<PackageOrder> ```|包裹单，当逆向消息为收货异常需要用这个接口|-
allPackageOrderLines|否|``` List<PackageOrderLine> ```|包裹单对应的所有包裹子单，这里主要为了计算包裹总单的状态用，当逆向消息为收货异常需要用这个接口|-
reverseOrderInfo|否|``` ReverseOrderInfo ```|售后单|-
order|否|``` Order ```|订单行对应的订单，逆向单肯定归属于同一个订单|-
allOrderLines|否|``` List<OrderLine> ```|订单对应的所有订单行，用来判断订单状态是否需要变更|-
needUpdate|否|``` boolean ```|是否需要更新各种单据，因为逆向状态变更消息在每次逆向发起（reverseCreate）的时候都会发，这种情况应该过滤不处理|-
updatedBy|否|``` String ```|操作人信息，internal的都是system，直接写死|-
packageOrderLineIdsToBeCanceled|否|``` List<Long> ```|这次要取消的发货单行id，在订单行按件数取消的场景下才有这个值|-
allReceived|否|``` Boolean ```|逆向完成后可能会触发订单状态流转为全部确认收货（如果之前已经全部确认收货，则此时返回false）|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` boolean ```

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` PackageOrderLine ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` ReverseOrderInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
reverseOrderId|否|``` Long ```|逆向单号|-
reverseTypesEnum|否|``` ReverseTypesEnum ```|逆向单类型|-
reverseState|否|``` ReverseStates ```|状态|-
bizCode|否|``` String ```|业务标识|-
purchaseOrderId|否|``` Long ```|购物单号|-
orderId|否|``` Long ```|订单号|-
quantity|否|``` Integer ```|申请逆向数量|-
refundAmount|否|``` Long ```|申请退款金额|-
actualRefundAmount|否|``` Long ```|实际退款金额|-
actualRefundShippingAmount|否|``` Long ```|实际退运费金额|-
reverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|逆向单行列表|-
reverseOrderLineGroupInfoList|否|``` List<ReverseOrderLineGroupInfo> ```|逆向单行分组列表|-
buyerId|否|``` Long ```|买家ID|-
buyerName|否|``` String ```|买家名称|-
buyerMobile|否|``` String ```|买家手机号|-
shopId|否|``` Long ```|卖家ID|-
shopName|否|``` String ```|卖家名称|-
sellerId|否|``` Long ```|商家ID|-
originalPayChannel|否|``` String ```|支付渠道|-
refundChannel|否|``` String ```|退款渠道|-
refundSerialNo|否|``` String ```|退款流水|-
refundAccount|否|``` String ```|退款账号|-
refundAt|否|``` Date ```|退款时间|-
reasonId|否|``` Integer ```|逆向原因|-
reasonText|否|``` String ```|逆向原因|-
buyerNotes|否|``` ReverseUserNotesInfo ```|买家备注|-
sellerNotes|否|``` ReverseUserNotesInfo ```|卖家备注|-
warehouseCode|否|``` String ```|仓Code|-
storePhone|否|``` String ```|门店电话|-
storeName|否|``` String ```|门店名称|-
warehouseInfo|否|``` ReverseWarehouseInfo ```|仓信息|-
storeInfo|否|``` ReverseStoreInfo ```|门店信息|-
buyerShippingAddress|否|``` ReverseShippingAddressInfo ```|买家地址|-
buyerReturnLogistics|否|``` Logistics ```|买家物流|-
sellerReplacementLogistics|否|``` Logistics ```|卖家物流|-
syncState|否|``` Integer ```|同步时间|-
createdBy|否|``` String ```|创建者|-
updatedBy|否|``` String ```|更新者|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
hasSynced|否|``` Boolean ```|是否同步|-
isSuccessFinalStatus|否|``` Boolean ```|是否处于终态|-
isReplacementOosRefund|否|``` Boolean ```|是否换货无货|-

``` ReverseUserNotesInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
notes|否|``` String ```|备注|-
imageNoteList|否|``` List<String> ```|图片|-

``` ReverseStoreInfo ```

>【已废弃】未实际使用


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|退货门店id|-
categoryTemplateId|否|``` Long ```|类目模版id|-
storeCode|否|``` String ```|门店码|-
name|否|``` String ```|门店名称|-
status|否|``` Integer ```|状态|-
provinceId|否|``` Long ```|-|-
cityId|否|``` Long ```|-|-
regionId|否|``` Long ```|-|-
streetId|否|``` Long ```|-|-
fullAddress|否|``` String ```|-|-
detailAddress|否|``` String ```|-|-
contactDTOList|否|``` List<ReverseContactInfo> ```|-|-
supportOrder|否|``` Boolean ```|-|-
supportDelivery|否|``` Boolean ```|-|-
supportPickUp|否|``` Boolean ```|-|-
poiCode|否|``` String ```|-|-

``` ReverseContactInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
contactName|否|``` String ```|-|-
contactMobile|否|``` String ```|-|-
contactDesc|否|``` String ```|-|-

``` ReverseShippingAddressInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|退货地址id|-
userId|否|``` Long ```|用户id|-
receiveUserName|否|``` String ```|收件人姓名|-
receiveUserDesc|否|``` String ```|收件人描述|-
phone|否|``` String ```|手机号|-
mobile|否|``` String ```|手机号|-
provinceId|否|``` Long ```|省份id|-
province|否|``` String ```|省份名|-
cityId|否|``` Long ```|城市id|-
city|否|``` String ```|城市名|-
regionId|否|``` Long ```|区县id|-
region|否|``` String ```|区县名|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道名|-
detail|否|``` String ```|详细地址|-
lat|否|``` String ```|-|-
lon|否|``` String ```|-|-
postcode|否|``` String ```|邮政编码|-
isDefault|否|``` Boolean ```|是否默认|-

``` Logistics ```

>物流信息


参数名|必填|类型|描述|说明
---|---|---|---|---
expressType|否|``` String ```|物流类型|-
companyCode|否|``` String ```|物流公司编码|-
companyName|否|``` String ```|物流公司名称|-
trackingNumber|否|``` String ```|物流编号|-
logisticFee|否|``` Long ```|物流费|-
trackInfoList|否|``` List<TrackInfo> ```|物流轨迹|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-

``` TrackInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
originTime|否|``` String ```|时间，原始格式|-
context|否|``` String ```|内容|-
formatTime|否|``` String ```|格式化后时间|-
areaCode|否|``` String ```|行政区域编码|-
areaName|否|``` String ```|行政区域名称|-
status|否|``` String ```|签收状态|-

``` ReverseOrderLineGroupInfo ```

>订单行组


参数名|必填|类型|描述|说明
---|---|---|---|---
masterReverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|bundle主行集合|-
slaveReverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|bundle附属行集合，可能为空|-

``` ReverseOrderLineInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|订单行ID|-
skuLineId|否|``` Long ```|逻辑订单行ID，同一sku因为寻源被拆分到两个仓而包含两个订单行|-
quantity|否|``` Integer ```|订单行上多少件商品发起逆向|-
initiateRefundAmount|否|``` Long ```|申请的退款金额|-
actualRefundAmount|否|``` Long ```|实际退款金额|-
actualRefundShippingAmount|否|``` Long ```|实际退运费金额|-
discountAmount|否|``` Long ```|订单行优惠分摊金额|-
memberPointsDeductAmount|否|``` Long ```|订单行分摊的积分数量|-
skuDetail|否|``` ReverseSkuDetailInfo ```|sku信息|-
bundleId|否|``` String ```|bundleId|-
masterId|否|``` Long ```|是否是bundle的主订单行|-

``` ReverseSkuDetailInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuId|-
skuCode|否|``` String ```|skuCode|-
skuName|否|``` String ```|skuName|-
skuAttributeList|否|``` List<ReverseSkuAttributeInfo> ```|销售属性|-
unitPrice|否|``` Long ```|单价|-
paidAmount|否|``` Long ```|实付金额|-
quantity|否|``` Integer ```|数量|-
mainImage|否|``` String ```|主图|-
itemId|否|``` Long ```|itemId|-
itemName|否|``` String ```|itemName|-
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-

``` ReverseSkuAttributeInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
attrKey|否|``` String ```|attrKey|-
attrVal|否|``` String ```|attrVal|-
unit|否|``` String ```|unit|-

``` ReverseTypesEnum ```

``` ReverseStates ```

``` ReverseWarehouseInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
name|否|``` String ```|name|-
code|否|``` String ```|code|-
shippingAddress|否|``` ReverseShippingAddressInfo ```|地址信息|-

``` PackageOrder ```

>发货单【已废弃，目前未实际使用】


参数名|必填|类型|描述|说明
---|---|---|---|---
packageOrderId|否|``` Long ```|物流单号|-
createdAt|否|``` Date ```|创建时间|-
tenantId|否|``` Integer ```|租户id|-
outId|否|``` String ```|外部id|-
shop|否|``` Shop ```|卖家id|-
buyerInfo|否|``` Buyer ```|买家信息|-
logisticsInfo|否|``` Logistics ```|物流信息|-
shippingAddressInfo|否|``` ShippingAddress ```|收货信息|-
status|否|``` String ```|状态|-
confirmDeadline|否|``` Date ```|确认截止时间|-
trackInfo|否|``` String ```|追踪信息|-
packageOrderLines|否|``` List<PackageOrderLine> ```|包裹子单|-
updatedAt|否|``` Date ```|更新时间|-
confirmAt|否|``` Date ```|确认收货时间|-
version|否|``` Integer ```|乐观锁版本号|-
warehouseCode|否|``` String ```|仓库code|-
warehouseName|否|``` String ```|仓库名称|-
extras|否|``` Extras ```|-|-
### 2. 订单详情查询上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderDetailQueryContext**



``` OrderDetailQueryContext ```

>订单详情查询上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
order|否|``` Order ```|订单领域模型(包含order 和 order line)|-
purchaseOrder|否|``` PurchaseOrder ```|购物单领域模型, (简单模型, 只包含购物单)|-
packageOrders|否|``` List<PackageOrder> ```|-|-
invoice|否|``` Invoice ```|-|-
orderDetailVO|否|``` OrderDetailVOInfo ```|返回值|-
operatorEnum|否|``` OperatorEnum ```|-|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` OperatorEnum ```

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-

``` PackageOrder ```

>发货单【已废弃，目前未实际使用】


参数名|必填|类型|描述|说明
---|---|---|---|---
packageOrderId|否|``` Long ```|物流单号|-
createdAt|否|``` Date ```|创建时间|-
tenantId|否|``` Integer ```|租户id|-
outId|否|``` String ```|外部id|-
shop|否|``` Shop ```|卖家id|-
buyerInfo|否|``` Buyer ```|买家信息|-
logisticsInfo|否|``` Logistics ```|物流信息|-
shippingAddressInfo|否|``` ShippingAddress ```|收货信息|-
status|否|``` String ```|状态|-
confirmDeadline|否|``` Date ```|确认截止时间|-
trackInfo|否|``` String ```|追踪信息|-
packageOrderLines|否|``` List<PackageOrderLine> ```|包裹子单|-
updatedAt|否|``` Date ```|更新时间|-
confirmAt|否|``` Date ```|确认收货时间|-
version|否|``` Integer ```|乐观锁版本号|-
warehouseCode|否|``` String ```|仓库code|-
warehouseName|否|``` String ```|仓库名称|-
extras|否|``` Extras ```|-|-

``` PackageOrderLine ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-

``` Logistics ```

>物流信息


参数名|必填|类型|描述|说明
---|---|---|---|---
expressType|否|``` String ```|物流类型|-
companyCode|否|``` String ```|物流公司编码|-
companyName|否|``` String ```|物流公司名称|-
trackingNumber|否|``` String ```|物流编号|-
logisticFee|否|``` Long ```|物流费|-
trackInfoList|否|``` List<TrackInfo> ```|物流轨迹|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-

``` TrackInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
originTime|否|``` String ```|时间，原始格式|-
context|否|``` String ```|内容|-
formatTime|否|``` String ```|格式化后时间|-
areaCode|否|``` String ```|行政区域编码|-
areaName|否|``` String ```|行政区域名称|-
status|否|``` String ```|签收状态|-

``` OrderDetailVOInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderDetailViewInfo|否|``` OrderDetailViewInfo ```|订单信息|-
orderLineViewInfos|否|``` List<OrderLineViewInfo> ```|子订单信息|-

``` OrderDetailViewInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
payAt|否|``` Date ```|支付完成时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|确认收货时间|-
totalFee|否|``` Long ```|合计金额|-
originalTaxFee|否|``` Long ```|原税费|-
shopDiscount|否|``` Long ```|店铺优惠金额|-
platformDiscount|否|``` Long ```|平台优惠金额|-
benefitDiscount|否|``` Long ```|权益优惠金额|-
deductedMemberPointsAmount|否|``` Long ```|积分抵扣数量|-
memberPointsDiscount|否|``` Long ```|积分抵扣金额|-
taxFeeDiscount|否|``` Long ```|税费优惠|-
salesAdjustFee|否|``` Long ```|销售金额改价|-
taxAjustFee|否|``` Long ```|税费改价|-
shippingAddress|否|``` ShippingAddressInfo ```|收货地址信息|-
invoice|否|``` OrderInvoiceInfo ```|发票信息|-
buyerNotes|否|``` String ```|买家留言|-
shopNotes|否|``` String ```|卖家留言|-
autoCancelTime|否|``` Date ```|支付超时时间|-
shop|否|``` Shop ```|店铺信息|-
orderId|否|``` Long ```|订单id|-
orderTitle|否|``` String ```|订单标题|-
skuOriginTotalAmount|否|``` Long ```|订单标题|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单id|-
outId|否|``` String ```|外部订单id|-
bizCode|否|``` String ```|业务类型|-
orderType|否|``` String ```|订单类型|-
totalFee|否|``` Long ```|下单金额|-
paidFee|否|``` Long ```|实际支付金额|-
originalShippingFee|否|``` Long ```|原始运费|-
shippingFeeDiscount|否|``` Long ```|运费优惠|-
shippingAdjustFee|否|``` Long ```|运费改价|-
shopId|否|``` Long ```|店铺id|-
shopName|否|``` String ```|店铺名称|-
buyerId|否|``` Long ```|买家id|-
buyerSubjectId|否|``` Long ```|买家主体id|-
buyerName|否|``` String ```|买家姓名|-
status|否|``` String ```|订单状态|-
createdAt|否|``` Date ```|下单时间|-
payTimeoutAt|否|``` Date ```|支付超时时间|-
operationInfos|否|``` LinkedHashSet<OrderOperationInfo> ```|可进行的操作|-
isInGroup|否|``` Integer ```|该订单是否与其它订单构成一笔购物单. 0: 否; 1: 是.|-
canComment|否|``` Boolean ```|是否能够评价|-
displayShippingFee|否|``` Long ```|展示的运费|-
packageOrderInfos|否|``` List<PackageOrderInfo> ```|发货包裹信息|-
autoConfirmTime|否|``` Date ```|自动确认收货时间|-
totalQuantity|否|``` Integer ```|-|-
commentAt|否|``` Date ```|-|-
paymentInfos|否|``` List<PaymentInfo> ```|支付信息|-
extraInfo|否|``` Map<String,String> ```|拓展信息|-
isForcePayment|否|``` Integer ```|预售支付尾款时, 选择完营销后并提交过一次后, 不能允许重复提交, 只能让用户直接支付|-
presaleInfo|否|``` PresaleInfo ```|预售信息|-
deviceSource|否|``` String ```|下单时的设备|-
canPay|否|``` Boolean ```|是否能够支付|-
canNotPayReason|否|``` String ```|不能支付原因|-
deliveryMode|否|``` String ```|配送模式|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
receivingWarehouseName|否|``` String ```|收货仓库|-
purchasingOrganizationName|否|``` String ```|采购组织|-
purchasingStaffName|否|``` String ```|采购员|-
upstreamOrderId|否|``` String ```|上游单据号|-

``` PackageOrderInfo ```

>包裹单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
packageOrderId|否|``` Long ```|包裹单id|-
tenantId|否|``` Integer ```|租户id|-
outId|否|``` String ```|外部id|-
corpCode|否|``` String ```|快递公司编号|-
corpName|否|``` String ```|快递公司名称|-
trackingNum|否|``` String ```|运单号|-
fulfilmentProgressCode|否|``` String ```|公共履约CODE|-
status|否|``` String ```|包裹状态: SHIPPED(300),CONFIRMED(400),DELIVER_ABNORMAL(503) |-
shippingAddressInfo|否|``` ShippingAddressInfo ```|收货地址详细信息|-
packageOrderLineInfos|否|``` List<PackageOrderLineInfo> ```|发货商品详细信息|-
trackInfo|否|``` String ```|物流轨迹详情|-
extraInfo|否|``` Map<String,String> ```|额外信息|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
confirmDeadline|否|``` Date ```|确认收货超时时间|-
expressType|否|``` String ```|物流类型|-
orderOperationInfos|否|``` Set<OrderOperationInfo> ```|订单操作信息列表|-
postponeConfirmPeriod|否|``` String ```|延长收货时可以延长的时间|-
postponeConfirmedTimes|否|``` Integer ```|已经延长收货的次数|-
storeInfo|否|``` Store ```|门店信息|-
buyerInfo|否|``` Buyer ```|买家信息|-
isConfirm|否|``` Boolean ```|收货状态|-
payAt|否|``` Date ```|支付完成时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|确认收货时间|-

``` PackageOrderLineInfo ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-
belongOtherOrder|否|``` Boolean ```|是否属于别的订单|-

``` Store ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|门店id|-
categoryTemplateId|否|``` Long ```|类目模板id|-
storeCode|否|``` String ```|门店编码|-
name|否|``` String ```|门店名|-
status|否|``` Integer ```|门店状态|-
provinceId|否|``` Long ```|省id|-
cityId|否|``` Long ```|城市id|-
regionId|否|``` Long ```|区域id|-
streetId|否|``` Long ```|街道id|-
fullAddress|否|``` String ```|完整地址|-
detailAddress|否|``` String ```|详细地址信息|-
contactDTOList|否|``` List<ShopContact> ```|联系人信息|-
supportOrder|否|``` Boolean ```|是否可发货|-
supportDelivery|否|``` Boolean ```|是否可配送|-
supportPickUp|否|``` Boolean ```|是否可自提|-
poiCode|否|``` String ```|poi编码|-
phone|否|``` String ```|联系方式|-
province|否|``` String ```|省份|-
city|否|``` String ```|城市|-
region|否|``` String ```|区域|-

``` ShopContact ```

参数名|必填|类型|描述|说明
---|---|---|---|---
contactName|否|``` String ```|联系人|-
contactMobile|否|``` String ```|联系人电话|-
contactDesc|否|``` String ```|联系人描述|-

``` ShippingAddressInfo ```

>发货地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户id|-
receiveUserName|否|``` String ```|收货人用户名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机号|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-

``` OrderOperationInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
value|否|``` int ```|标识操作id|-
text|否|``` String ```|显示的文案|-
operator|否|``` List<String> ```|可以触发这个动作的角色列表|-

``` int ```

``` PresaleInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
canPayLast|否|``` Integer ```|是否能够支付尾款, 0:否,1:是|-
estimatedShippingTime|否|``` Date ```|预售预计发货时间|-
payNoticePhoneNum|否|``` String ```|预售尾款通知手机号|-
lastPayStartTime|否|``` Date ```|预售尾款支付开始时间|-
lastPayEndTime|否|``` Date ```|预售尾款支付结束时间|-
depositAmount|否|``` Long ```|定金实付金额|-
despositPayAt|否|``` Date ```|定金支付时间|-
lastPayAmount|否|``` Long ```|尾款金额|-
lastPayAt|否|``` Date ```|尾款支付时间|-
depositOriginAmount|否|``` Long ```|定金应付金额|-
lastPayOriginAmount|否|``` Long ```|尾款应付金额|-

``` LinkedHashSet<OrderOperationInfo> ```

``` PaymentInfo ```

>订单中冗余存储支付单相关信息 对应表字段 payment_json


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentMethod|否|``` Integer ```|支付方式|-
paymentOrderId|否|``` Long ```|支付单id|-
paymentChannel|否|``` String ```|支付渠道|-
externalTradeNo|否|``` String ```|支付平台流水号|-
status|否|``` String ```|支付单状态|-
totalStages|否|``` Integer ```|订单的总支付阶段数|-
paymentAmount|否|``` Long ```|每阶段的实付金额|-
originAmount|否|``` Long ```|每阶段的原始金额|-
stage|否|``` Integer ```|该笔支付的阶段|-
requiredStartTime|否|``` Date ```|-|-
requiredEndTime|否|``` Date ```|-|-
payAt|否|``` Date ```|-|-
paymentChannelText|否|``` String ```|支付渠道展示的文案|-

``` OrderInvoiceInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用|-
invoiceType|否|``` String ```|发票类型：蓝票，红票|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|-|-
regPhone|否|``` String ```|-|-
regBankName|否|``` String ```|-|-
regBankAccount|否|``` String ```|-|-
isValid|否|``` int ```|该发票是否有效|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
invoiceCode|否|``` String ```|-|-
invoiceId|否|``` String ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-

``` OrderLineViewInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|子订单id|-
warehouseCode|否|``` String ```|发货仓id|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|子订单业务类型|-
status|否|``` String ```|子订单状态|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
quantity|否|``` Integer ```|子订单购买sku数量|-
skuInfo|否|``` SkuInfo ```|sku模型|-
payPriceDetail|否|``` PayPriceDetail ```|支付数据详情|-
displayFee|否|``` Long ```|展示的销售单价|-
unitPrice|否|``` Long ```|原单价|-
operationInfos|否|``` Set<OrderOperationInfo> ```|操作按钮集合|-
canComment|否|``` Boolean ```|是否能够评价|-
shipableQuantity|否|``` Integer ```|剩余可以发货的数量|-
extraInfo|否|``` Map<String,String> ```|-|-
reverseStatus|否|``` String ```|-|-
exceptionReason|否|``` String ```|-|-
isGift|否|``` Boolean ```|是否为赠品|-
partialOrderLineReverse|否|``` Boolean ```|是否发生订单行级别内退款|-
reverseDetails|否|``` List<ReverseReasonDetailInfo> ```|逆向详情|-
goodsCode|否|``` String ```|门店商品编码|-
childOrderLineViewInfo|否|``` List ```|配方订单详情列表|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
unit|否|``` String ```|基本单位|-
planDeliveryAt|否|``` Date ```|需求交货日期|-

``` PayPriceDetail ```

参数名|必填|类型|描述|说明
---|---|---|---|---
paidMoney|否|``` Long ```|支付的金额|-
memberPointsDeduct|否|``` Long ```|积分抵扣金额|-
memberPointsAmount|否|``` Long ```|抵扣的积分数量|-
shoppingCardDeduct|否|``` Long ```|购物卡抵扣|-
virtualCoinAmount|否|``` String ```|阅读币|-

``` ReverseReasonDetailInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
reverseType|否|``` String ```|取消订单或者设为异常|-
reverseReason|否|``` String ```|-|-
reverseQuantity|否|``` Integer ```|-|-

``` SkuInfo ```

>sku信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuId|-
skuCode|否|``` String ```|编码|-
outerId|否|``` String ```|外部id|-
item|否|``` ItemInfo ```|商品信息|-
skuName|否|``` String ```|商品名|-
shopId|否|``` Long ```|店铺id|-
image|否|``` String ```|主图|-
price|否|``` Long ```|价格|-
attributes|否|``` Object ```|销售属性集合|-
extraPrice|否|``` Map<String,Long> ```|特殊价格,特殊价格包括渠道价格等|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|商品类型|-
businessType|否|``` Integer ```|业务类型|-
inventoryType|否|``` Integer ```|库存类型|-
skuIds|否|``` Map<Long,Integer> ```|关联库存SkuIds以及对象的数量映射, 存储格式为库存skuId+对应数量|-
tags|否|``` Long ```|标签|-
skuTags|否|``` List<ItemTagInfo> ```|商品标记|-
promotionExtraPrices|否|``` Map<Integer,Long> ```|额外优惠价格|-
channelInfo|否|``` ChannelInfo ```|渠道信息|-
purchaseLimit|否|``` Integer ```|购买数量限制|-
isVirtual|否|``` Boolean ```|是虚拟商品还是实体商品|-
skuExtra|否|``` Extras ```|sku的冗余信息|-
isOnShelf|否|``` Boolean ```|是否上架|-

``` ChannelInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
name|否|``` String ```|渠道名称|-
status|否|``` Integer ```|渠道状态|请使用ChannelStatusType进行解析
discount|否|``` Integer ```|渠道折扣|取值范围：0~100
sourceLink|否|``` String ```|渠道链接|-
token|否|``` String ```|渠道令牌|-
takeEffectAt|否|``` Date ```|渠道生效时间|-
loseEffectAt|否|``` Date ```|渠道失效时间|-

``` ItemTagInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|商品标记id|-
sourceId|否|``` Long ```|商品标记源id|-
name|否|``` String ```|商品标记名称|-
group|否|``` Integer ```|商品标记分组|-
type|否|``` Integer ```|商品标记类型|-
content|否|``` Map<String,String> ```|商品标记内容|-

``` ItemInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|商品ID|-
itemCode|否|``` String ```|商品编码|-
shopId|否|``` Long ```|店铺ID|-
shopName|否|``` String ```|店铺名称|-
categoryId|否|``` Long ```|类目ID|-
categoryIds|否|``` List<Long> ```|类目ID列表|-
brandId|否|``` Long ```|品牌ID|-
brandName|否|``` String ```|品牌名称|-
deliveryFeeTempId|否|``` Long ```|运费模板ID|-
name|否|``` String ```|商品名称|-
advertise|否|``` String ```|广告词|-
mainImage|否|``` String ```|主图|-
videoUrl|否|``` String ```|视频地址|-
lowPrice|否|``` Integer ```|最低价|-
highPrice|否|``` Integer ```|最高价|-
status|否|``` Integer ```|商品状态|-
supportVAT|否|``` Boolean ```|是否支持增值税发票|-
md5Info|否|``` String ```|md5 信息|-
isOnShelf|否|``` Boolean ```|是否已上架|-
unitWeight|否|``` Long ```|单位重量|-
unit|否|``` String ```|计量单位|-
type|否|``` Integer ```|商品类型|-
extra|否|``` Map<String,Object> ```|扩展字段|-
buyCategoryTax|否|``` ItemTaxRateInfo ```|税费相关|-

``` ItemTaxRateInfo ```

>商品税信息


参数名|必填|类型|描述|说明
---|---|---|---|---
itemId|否|``` Long ```|商品ID|-
rateCode|否|``` String ```|税收编码|-
rate|否|``` String ```|税率|-
categoryIds|否|``` List<Long> ```|类目集合|-
### 3. 购物单支付后更新上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.PurchaseOrderInternalUpdateAfterPaidContext**



``` PurchaseOrderInternalUpdateAfterPaidContext ```

>购物单支付后更新上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrder|否|``` PurchaseOrder ```|购物单信息|-
payment|否|``` PaymentOrder ```|本次支付的支付单信息|-
updatedBy|否|``` String ```|操作人信息，internal的都是system，直接写死|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-
### 4. 订单支付更新上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderPaymentUpdateContext**



``` OrderPaymentUpdateContext ```

>订单支付更新上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrders|否|``` List<PurchaseOrder> ```|-|-
updateOrderLines|否|``` List<OrderLine> ```|-|-
updatedBy|否|``` String ```|操作人信息，internal的都是system，直接写死|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-
### 5. 购物单支付状态上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.PurchaseOrderUpdatePayStatusContext**



``` PurchaseOrderUpdatePayStatusContext ```

>购物单支付状态上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrder|否|``` PurchaseOrder ```|购物单对象|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-
### 6. 购物单内部创建上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.PurchaseOrderInternalCreateContext**



``` PurchaseOrderInternalCreateContext ```

>购物单内部创建上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrder|否|``` PurchaseOrder ```|-|-
extra|否|``` Map<String,String> ```|-|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-
### 7. 订单收货后更新上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderUpdateAfterConfirmContext**



``` OrderUpdateAfterConfirmContext ```

>订单收货后更新上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
confirmedOrderLines|否|``` List<OrderLine> ```|收货完成的订单行|-
confirmedOrders|否|``` List<Order> ```|收货完成的订单|-
needUpdatedOrderLines|否|``` List<OrderLine> ```|需要更新状态的订单行|-
needUpdatedOrders|否|``` List<Order> ```|需要更新状态的订单|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-
### 8. 订单列表查询上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderListQueryContext**



``` OrderListQueryContext ```

>订单列表查询上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
order|否|``` Order ```|入参|-
operator|否|``` Operator ```|操作角色|-
purchaseOrder|否|``` PurchaseOrder ```|购物单信息|-
packageOrders|否|``` List<PackageOrder> ```|包裹单信息, 这里包含的是某一个分页下所有的包裹单只有商家列表需要查询|-
reverseOrderInfos|否|``` List<ReverseOrderInfo> ```|逆向单信息|-
orderListInfo|否|``` OrderListViewInfo ```|返回值|-
reverseQuantityByOrderLineId|否|``` Map<Long,Integer> ```|每个订单行的申请逆向数量|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` PackageOrder ```

>发货单【已废弃，目前未实际使用】


参数名|必填|类型|描述|说明
---|---|---|---|---
packageOrderId|否|``` Long ```|物流单号|-
createdAt|否|``` Date ```|创建时间|-
tenantId|否|``` Integer ```|租户id|-
outId|否|``` String ```|外部id|-
shop|否|``` Shop ```|卖家id|-
buyerInfo|否|``` Buyer ```|买家信息|-
logisticsInfo|否|``` Logistics ```|物流信息|-
shippingAddressInfo|否|``` ShippingAddress ```|收货信息|-
status|否|``` String ```|状态|-
confirmDeadline|否|``` Date ```|确认截止时间|-
trackInfo|否|``` String ```|追踪信息|-
packageOrderLines|否|``` List<PackageOrderLine> ```|包裹子单|-
updatedAt|否|``` Date ```|更新时间|-
confirmAt|否|``` Date ```|确认收货时间|-
version|否|``` Integer ```|乐观锁版本号|-
warehouseCode|否|``` String ```|仓库code|-
warehouseName|否|``` String ```|仓库名称|-
extras|否|``` Extras ```|-|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` PackageOrderLine ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-

``` Logistics ```

>物流信息


参数名|必填|类型|描述|说明
---|---|---|---|---
expressType|否|``` String ```|物流类型|-
companyCode|否|``` String ```|物流公司编码|-
companyName|否|``` String ```|物流公司名称|-
trackingNumber|否|``` String ```|物流编号|-
logisticFee|否|``` Long ```|物流费|-
trackInfoList|否|``` List<TrackInfo> ```|物流轨迹|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-

``` TrackInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
originTime|否|``` String ```|时间，原始格式|-
context|否|``` String ```|内容|-
formatTime|否|``` String ```|格式化后时间|-
areaCode|否|``` String ```|行政区域编码|-
areaName|否|``` String ```|行政区域名称|-
status|否|``` String ```|签收状态|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` OrderListViewInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderViewInfo|否|``` OrderViewInfo ```|订单信息|-
orderLineViewInfos|否|``` List<OrderLineViewInfo> ```|子订单信息|-

``` OrderViewInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单id|-
orderTitle|否|``` String ```|订单标题|-
skuOriginTotalAmount|否|``` Long ```|订单标题|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单id|-
outId|否|``` String ```|外部订单id|-
bizCode|否|``` String ```|业务类型|-
orderType|否|``` String ```|订单类型|-
totalFee|否|``` Long ```|下单金额|-
paidFee|否|``` Long ```|实际支付金额|-
originalShippingFee|否|``` Long ```|原始运费|-
shippingFeeDiscount|否|``` Long ```|运费优惠|-
shippingAdjustFee|否|``` Long ```|运费改价|-
shopId|否|``` Long ```|店铺id|-
shopName|否|``` String ```|店铺名称|-
buyerId|否|``` Long ```|买家id|-
buyerSubjectId|否|``` Long ```|买家主体id|-
buyerName|否|``` String ```|买家姓名|-
status|否|``` String ```|订单状态|-
createdAt|否|``` Date ```|下单时间|-
payTimeoutAt|否|``` Date ```|支付超时时间|-
operationInfos|否|``` LinkedHashSet<OrderOperationInfo> ```|可进行的操作|-
isInGroup|否|``` Integer ```|该订单是否与其它订单构成一笔购物单. 0: 否; 1: 是.|-
canComment|否|``` Boolean ```|是否能够评价|-
displayShippingFee|否|``` Long ```|展示的运费|-
packageOrderInfos|否|``` List<PackageOrderInfo> ```|发货包裹信息|-
autoConfirmTime|否|``` Date ```|自动确认收货时间|-
totalQuantity|否|``` Integer ```|-|-
commentAt|否|``` Date ```|-|-
paymentInfos|否|``` List<PaymentInfo> ```|支付信息|-
extraInfo|否|``` Map<String,String> ```|拓展信息|-
isForcePayment|否|``` Integer ```|预售支付尾款时, 选择完营销后并提交过一次后, 不能允许重复提交, 只能让用户直接支付|-
presaleInfo|否|``` PresaleInfo ```|预售信息|-
deviceSource|否|``` String ```|下单时的设备|-
canPay|否|``` Boolean ```|是否能够支付|-
canNotPayReason|否|``` String ```|不能支付原因|-
deliveryMode|否|``` String ```|配送模式|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
receivingWarehouseName|否|``` String ```|收货仓库|-
purchasingOrganizationName|否|``` String ```|采购组织|-
purchasingStaffName|否|``` String ```|采购员|-
upstreamOrderId|否|``` String ```|上游单据号|-

``` PresaleInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
canPayLast|否|``` Integer ```|是否能够支付尾款, 0:否,1:是|-
estimatedShippingTime|否|``` Date ```|预售预计发货时间|-
payNoticePhoneNum|否|``` String ```|预售尾款通知手机号|-
lastPayStartTime|否|``` Date ```|预售尾款支付开始时间|-
lastPayEndTime|否|``` Date ```|预售尾款支付结束时间|-
depositAmount|否|``` Long ```|定金实付金额|-
despositPayAt|否|``` Date ```|定金支付时间|-
lastPayAmount|否|``` Long ```|尾款金额|-
lastPayAt|否|``` Date ```|尾款支付时间|-
depositOriginAmount|否|``` Long ```|定金应付金额|-
lastPayOriginAmount|否|``` Long ```|尾款应付金额|-

``` LinkedHashSet<OrderOperationInfo> ```

``` OrderOperationInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
value|否|``` int ```|标识操作id|-
text|否|``` String ```|显示的文案|-
operator|否|``` List<String> ```|可以触发这个动作的角色列表|-

``` int ```

``` PackageOrderInfo ```

>包裹单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
packageOrderId|否|``` Long ```|包裹单id|-
tenantId|否|``` Integer ```|租户id|-
outId|否|``` String ```|外部id|-
corpCode|否|``` String ```|快递公司编号|-
corpName|否|``` String ```|快递公司名称|-
trackingNum|否|``` String ```|运单号|-
fulfilmentProgressCode|否|``` String ```|公共履约CODE|-
status|否|``` String ```|包裹状态: SHIPPED(300),CONFIRMED(400),DELIVER_ABNORMAL(503) |-
shippingAddressInfo|否|``` ShippingAddressInfo ```|收货地址详细信息|-
packageOrderLineInfos|否|``` List<PackageOrderLineInfo> ```|发货商品详细信息|-
trackInfo|否|``` String ```|物流轨迹详情|-
extraInfo|否|``` Map<String,String> ```|额外信息|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
confirmDeadline|否|``` Date ```|确认收货超时时间|-
expressType|否|``` String ```|物流类型|-
orderOperationInfos|否|``` Set<OrderOperationInfo> ```|订单操作信息列表|-
postponeConfirmPeriod|否|``` String ```|延长收货时可以延长的时间|-
postponeConfirmedTimes|否|``` Integer ```|已经延长收货的次数|-
storeInfo|否|``` Store ```|门店信息|-
buyerInfo|否|``` Buyer ```|买家信息|-
isConfirm|否|``` Boolean ```|收货状态|-
payAt|否|``` Date ```|支付完成时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|确认收货时间|-

``` PackageOrderLineInfo ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-
belongOtherOrder|否|``` Boolean ```|是否属于别的订单|-

``` ShippingAddressInfo ```

>发货地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户id|-
receiveUserName|否|``` String ```|收货人用户名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机号|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-

``` Store ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|门店id|-
categoryTemplateId|否|``` Long ```|类目模板id|-
storeCode|否|``` String ```|门店编码|-
name|否|``` String ```|门店名|-
status|否|``` Integer ```|门店状态|-
provinceId|否|``` Long ```|省id|-
cityId|否|``` Long ```|城市id|-
regionId|否|``` Long ```|区域id|-
streetId|否|``` Long ```|街道id|-
fullAddress|否|``` String ```|完整地址|-
detailAddress|否|``` String ```|详细地址信息|-
contactDTOList|否|``` List<ShopContact> ```|联系人信息|-
supportOrder|否|``` Boolean ```|是否可发货|-
supportDelivery|否|``` Boolean ```|是否可配送|-
supportPickUp|否|``` Boolean ```|是否可自提|-
poiCode|否|``` String ```|poi编码|-
phone|否|``` String ```|联系方式|-
province|否|``` String ```|省份|-
city|否|``` String ```|城市|-
region|否|``` String ```|区域|-

``` ShopContact ```

参数名|必填|类型|描述|说明
---|---|---|---|---
contactName|否|``` String ```|联系人|-
contactMobile|否|``` String ```|联系人电话|-
contactDesc|否|``` String ```|联系人描述|-

``` PaymentInfo ```

>订单中冗余存储支付单相关信息 对应表字段 payment_json


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentMethod|否|``` Integer ```|支付方式|-
paymentOrderId|否|``` Long ```|支付单id|-
paymentChannel|否|``` String ```|支付渠道|-
externalTradeNo|否|``` String ```|支付平台流水号|-
status|否|``` String ```|支付单状态|-
totalStages|否|``` Integer ```|订单的总支付阶段数|-
paymentAmount|否|``` Long ```|每阶段的实付金额|-
originAmount|否|``` Long ```|每阶段的原始金额|-
stage|否|``` Integer ```|该笔支付的阶段|-
requiredStartTime|否|``` Date ```|-|-
requiredEndTime|否|``` Date ```|-|-
payAt|否|``` Date ```|-|-
paymentChannelText|否|``` String ```|支付渠道展示的文案|-

``` OrderLineViewInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|子订单id|-
warehouseCode|否|``` String ```|发货仓id|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|子订单业务类型|-
status|否|``` String ```|子订单状态|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
quantity|否|``` Integer ```|子订单购买sku数量|-
skuInfo|否|``` SkuInfo ```|sku模型|-
payPriceDetail|否|``` PayPriceDetail ```|支付数据详情|-
displayFee|否|``` Long ```|展示的销售单价|-
unitPrice|否|``` Long ```|原单价|-
operationInfos|否|``` Set<OrderOperationInfo> ```|操作按钮集合|-
canComment|否|``` Boolean ```|是否能够评价|-
shipableQuantity|否|``` Integer ```|剩余可以发货的数量|-
extraInfo|否|``` Map<String,String> ```|-|-
reverseStatus|否|``` String ```|-|-
exceptionReason|否|``` String ```|-|-
isGift|否|``` Boolean ```|是否为赠品|-
partialOrderLineReverse|否|``` Boolean ```|是否发生订单行级别内退款|-
reverseDetails|否|``` List<ReverseReasonDetailInfo> ```|逆向详情|-
goodsCode|否|``` String ```|门店商品编码|-
childOrderLineViewInfo|否|``` List ```|配方订单详情列表|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
unit|否|``` String ```|基本单位|-
planDeliveryAt|否|``` Date ```|需求交货日期|-

``` ReverseReasonDetailInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
reverseType|否|``` String ```|取消订单或者设为异常|-
reverseReason|否|``` String ```|-|-
reverseQuantity|否|``` Integer ```|-|-

``` PayPriceDetail ```

参数名|必填|类型|描述|说明
---|---|---|---|---
paidMoney|否|``` Long ```|支付的金额|-
memberPointsDeduct|否|``` Long ```|积分抵扣金额|-
memberPointsAmount|否|``` Long ```|抵扣的积分数量|-
shoppingCardDeduct|否|``` Long ```|购物卡抵扣|-
virtualCoinAmount|否|``` String ```|阅读币|-

``` SkuInfo ```

>sku信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuId|-
skuCode|否|``` String ```|编码|-
outerId|否|``` String ```|外部id|-
item|否|``` ItemInfo ```|商品信息|-
skuName|否|``` String ```|商品名|-
shopId|否|``` Long ```|店铺id|-
image|否|``` String ```|主图|-
price|否|``` Long ```|价格|-
attributes|否|``` Object ```|销售属性集合|-
extraPrice|否|``` Map<String,Long> ```|特殊价格,特殊价格包括渠道价格等|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|商品类型|-
businessType|否|``` Integer ```|业务类型|-
inventoryType|否|``` Integer ```|库存类型|-
skuIds|否|``` Map<Long,Integer> ```|关联库存SkuIds以及对象的数量映射, 存储格式为库存skuId+对应数量|-
tags|否|``` Long ```|标签|-
skuTags|否|``` List<ItemTagInfo> ```|商品标记|-
promotionExtraPrices|否|``` Map<Integer,Long> ```|额外优惠价格|-
channelInfo|否|``` ChannelInfo ```|渠道信息|-
purchaseLimit|否|``` Integer ```|购买数量限制|-
isVirtual|否|``` Boolean ```|是虚拟商品还是实体商品|-
skuExtra|否|``` Extras ```|sku的冗余信息|-
isOnShelf|否|``` Boolean ```|是否上架|-

``` ItemInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|商品ID|-
itemCode|否|``` String ```|商品编码|-
shopId|否|``` Long ```|店铺ID|-
shopName|否|``` String ```|店铺名称|-
categoryId|否|``` Long ```|类目ID|-
categoryIds|否|``` List<Long> ```|类目ID列表|-
brandId|否|``` Long ```|品牌ID|-
brandName|否|``` String ```|品牌名称|-
deliveryFeeTempId|否|``` Long ```|运费模板ID|-
name|否|``` String ```|商品名称|-
advertise|否|``` String ```|广告词|-
mainImage|否|``` String ```|主图|-
videoUrl|否|``` String ```|视频地址|-
lowPrice|否|``` Integer ```|最低价|-
highPrice|否|``` Integer ```|最高价|-
status|否|``` Integer ```|商品状态|-
supportVAT|否|``` Boolean ```|是否支持增值税发票|-
md5Info|否|``` String ```|md5 信息|-
isOnShelf|否|``` Boolean ```|是否已上架|-
unitWeight|否|``` Long ```|单位重量|-
unit|否|``` String ```|计量单位|-
type|否|``` Integer ```|商品类型|-
extra|否|``` Map<String,Object> ```|扩展字段|-
buyCategoryTax|否|``` ItemTaxRateInfo ```|税费相关|-

``` ItemTaxRateInfo ```

>商品税信息


参数名|必填|类型|描述|说明
---|---|---|---|---
itemId|否|``` Long ```|商品ID|-
rateCode|否|``` String ```|税收编码|-
rate|否|``` String ```|税率|-
categoryIds|否|``` List<Long> ```|类目集合|-

``` ItemTagInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|商品标记id|-
sourceId|否|``` Long ```|商品标记源id|-
name|否|``` String ```|商品标记名称|-
group|否|``` Integer ```|商品标记分组|-
type|否|``` Integer ```|商品标记类型|-
content|否|``` Map<String,String> ```|商品标记内容|-

``` ChannelInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
name|否|``` String ```|渠道名称|-
status|否|``` Integer ```|渠道状态|请使用ChannelStatusType进行解析
discount|否|``` Integer ```|渠道折扣|取值范围：0~100
sourceLink|否|``` String ```|渠道链接|-
token|否|``` String ```|渠道令牌|-
takeEffectAt|否|``` Date ```|渠道生效时间|-
loseEffectAt|否|``` Date ```|渠道失效时间|-

``` ReverseOrderInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
reverseOrderId|否|``` Long ```|逆向单号|-
reverseTypesEnum|否|``` ReverseTypesEnum ```|逆向单类型|-
reverseState|否|``` ReverseStates ```|状态|-
bizCode|否|``` String ```|业务标识|-
purchaseOrderId|否|``` Long ```|购物单号|-
orderId|否|``` Long ```|订单号|-
quantity|否|``` Integer ```|申请逆向数量|-
refundAmount|否|``` Long ```|申请退款金额|-
actualRefundAmount|否|``` Long ```|实际退款金额|-
actualRefundShippingAmount|否|``` Long ```|实际退运费金额|-
reverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|逆向单行列表|-
reverseOrderLineGroupInfoList|否|``` List<ReverseOrderLineGroupInfo> ```|逆向单行分组列表|-
buyerId|否|``` Long ```|买家ID|-
buyerName|否|``` String ```|买家名称|-
buyerMobile|否|``` String ```|买家手机号|-
shopId|否|``` Long ```|卖家ID|-
shopName|否|``` String ```|卖家名称|-
sellerId|否|``` Long ```|商家ID|-
originalPayChannel|否|``` String ```|支付渠道|-
refundChannel|否|``` String ```|退款渠道|-
refundSerialNo|否|``` String ```|退款流水|-
refundAccount|否|``` String ```|退款账号|-
refundAt|否|``` Date ```|退款时间|-
reasonId|否|``` Integer ```|逆向原因|-
reasonText|否|``` String ```|逆向原因|-
buyerNotes|否|``` ReverseUserNotesInfo ```|买家备注|-
sellerNotes|否|``` ReverseUserNotesInfo ```|卖家备注|-
warehouseCode|否|``` String ```|仓Code|-
storePhone|否|``` String ```|门店电话|-
storeName|否|``` String ```|门店名称|-
warehouseInfo|否|``` ReverseWarehouseInfo ```|仓信息|-
storeInfo|否|``` ReverseStoreInfo ```|门店信息|-
buyerShippingAddress|否|``` ReverseShippingAddressInfo ```|买家地址|-
buyerReturnLogistics|否|``` Logistics ```|买家物流|-
sellerReplacementLogistics|否|``` Logistics ```|卖家物流|-
syncState|否|``` Integer ```|同步时间|-
createdBy|否|``` String ```|创建者|-
updatedBy|否|``` String ```|更新者|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
hasSynced|否|``` Boolean ```|是否同步|-
isSuccessFinalStatus|否|``` Boolean ```|是否处于终态|-
isReplacementOosRefund|否|``` Boolean ```|是否换货无货|-

``` ReverseStoreInfo ```

>【已废弃】未实际使用


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|退货门店id|-
categoryTemplateId|否|``` Long ```|类目模版id|-
storeCode|否|``` String ```|门店码|-
name|否|``` String ```|门店名称|-
status|否|``` Integer ```|状态|-
provinceId|否|``` Long ```|-|-
cityId|否|``` Long ```|-|-
regionId|否|``` Long ```|-|-
streetId|否|``` Long ```|-|-
fullAddress|否|``` String ```|-|-
detailAddress|否|``` String ```|-|-
contactDTOList|否|``` List<ReverseContactInfo> ```|-|-
supportOrder|否|``` Boolean ```|-|-
supportDelivery|否|``` Boolean ```|-|-
supportPickUp|否|``` Boolean ```|-|-
poiCode|否|``` String ```|-|-

``` ReverseContactInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
contactName|否|``` String ```|-|-
contactMobile|否|``` String ```|-|-
contactDesc|否|``` String ```|-|-

``` ReverseOrderLineGroupInfo ```

>订单行组


参数名|必填|类型|描述|说明
---|---|---|---|---
masterReverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|bundle主行集合|-
slaveReverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|bundle附属行集合，可能为空|-

``` ReverseOrderLineInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|订单行ID|-
skuLineId|否|``` Long ```|逻辑订单行ID，同一sku因为寻源被拆分到两个仓而包含两个订单行|-
quantity|否|``` Integer ```|订单行上多少件商品发起逆向|-
initiateRefundAmount|否|``` Long ```|申请的退款金额|-
actualRefundAmount|否|``` Long ```|实际退款金额|-
actualRefundShippingAmount|否|``` Long ```|实际退运费金额|-
discountAmount|否|``` Long ```|订单行优惠分摊金额|-
memberPointsDeductAmount|否|``` Long ```|订单行分摊的积分数量|-
skuDetail|否|``` ReverseSkuDetailInfo ```|sku信息|-
bundleId|否|``` String ```|bundleId|-
masterId|否|``` Long ```|是否是bundle的主订单行|-

``` ReverseSkuDetailInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuId|-
skuCode|否|``` String ```|skuCode|-
skuName|否|``` String ```|skuName|-
skuAttributeList|否|``` List<ReverseSkuAttributeInfo> ```|销售属性|-
unitPrice|否|``` Long ```|单价|-
paidAmount|否|``` Long ```|实付金额|-
quantity|否|``` Integer ```|数量|-
mainImage|否|``` String ```|主图|-
itemId|否|``` Long ```|itemId|-
itemName|否|``` String ```|itemName|-
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-

``` ReverseSkuAttributeInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
attrKey|否|``` String ```|attrKey|-
attrVal|否|``` String ```|attrVal|-
unit|否|``` String ```|unit|-

``` ReverseUserNotesInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
notes|否|``` String ```|备注|-
imageNoteList|否|``` List<String> ```|图片|-

``` ReverseWarehouseInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
name|否|``` String ```|name|-
code|否|``` String ```|code|-
shippingAddress|否|``` ReverseShippingAddressInfo ```|地址信息|-

``` ReverseShippingAddressInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|退货地址id|-
userId|否|``` Long ```|用户id|-
receiveUserName|否|``` String ```|收件人姓名|-
receiveUserDesc|否|``` String ```|收件人描述|-
phone|否|``` String ```|手机号|-
mobile|否|``` String ```|手机号|-
provinceId|否|``` Long ```|省份id|-
province|否|``` String ```|省份名|-
cityId|否|``` Long ```|城市id|-
city|否|``` String ```|城市名|-
regionId|否|``` Long ```|区县id|-
region|否|``` String ```|区县名|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道名|-
detail|否|``` String ```|详细地址|-
lat|否|``` String ```|-|-
lon|否|``` String ```|-|-
postcode|否|``` String ```|邮政编码|-
isDefault|否|``` Boolean ```|是否默认|-

``` ReverseStates ```

``` ReverseTypesEnum ```

``` Operator ```

参数名|必填|类型|描述|说明
---|---|---|---|---
operatorId|否|``` Long ```|操作人编号|-
operatorRole|否|``` String ```|主体角色|-
parentId|否|``` Long ```|所属主账号id, 对于卖家而言就是shop id对于仓库而言, 就是 warehouse_code|-
### 9. 订单逆向单创建更新上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderUpdateAfterReverseCreateContext**



``` OrderUpdateAfterReverseCreateContext ```

>订单逆向单创建更新上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
reverseBizCode|否|``` String ```|逆向单类型|-
reverseStatus|否|``` String ```|逆向单状态|-
isException|否|``` Boolean ```|是否收货异常订单|-
orderLines|否|``` List<OrderLine> ```|这次逆向操作涉及的订单行信息，这里应该只需要用到订单行id|-
orderLinesToUpdate|否|``` List<OrderLine> ```|需要更新的订单行|-
order|否|``` Order ```|订单行对应的订单，逆向单肯定归属于同一个订单|-
orderToUpdate|否|``` Order ```|需要更新的订单|-
allOrderLines|否|``` List<OrderLine> ```|订单对应的所有订单行，用来判断订单状态是否需要变更|-
updatedBy|否|``` String ```|操作人信息，internal的都是system，直接写死|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-
### 10. 订单评论上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderCommentContext**



``` OrderCommentContext ```

>订单评论上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
orderComments|否|``` List<OrderComment> ```|-|-
userId|否|``` Long ```|-|-
username|否|``` String ```|-|-
avatarUrl|否|``` String ```|-|-
userType|否|``` int ```|-|-
tenantId|否|``` Integer ```|-|-
updatedBy|否|``` String ```|-|-
order|否|``` Order ```|-|-
pursue|否|``` boolean ```|默认不是追评|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` boolean ```

``` int ```

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` OrderComment ```

参数名|必填|类型|描述|说明
---|---|---|---|---
itemId|否|``` Long ```|商品id|-
itemName|否|``` String ```|商品名称|-
mainImg|否|``` String ```|主图|-
shopId|否|``` Long ```|店铺id|-
sellerId|否|``` Long ```|卖家ID|-
orderLineId|否|``` Long ```|订单id|-
sourceId|否|``` Long ```|追加评论的id|-
quality|否|``` Integer ```|星级|-
comment|否|``` String ```|评论内容|-
skuAttributes|否|``` Map<String,String> ```|sku销售属性|-
images|否|``` List<String> ```|评论添加图片|-
itemMd5|否|``` String ```|-|-
extra|否|``` Map<String,String> ```|其它信息|-
price|否|``` Long ```|订单实付金额|-
commentStatus|否|``` String ```|评价状态|-
### 11. 订单收货后更新上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderUpdateAfterShippedContext**



``` OrderUpdateAfterShippedContext ```

>订单收货后更新上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
shippedOrderLines|否|``` List<OrderLine> ```|已发货的订单行|-
shippedOrders|否|``` List<Order> ```|已发货的订单|-
needUpdatedOrderLines|否|``` List<OrderLine> ```|需要更新状态的订单行|-
needUpdatedOrders|否|``` List<Order> ```|需要更新状态的订单|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-
### 12. 购物单内部启用上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.PurchaseOrderInternalEnableContext**



``` PurchaseOrderInternalEnableContext ```

>购物单内部启用上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单ID|-
tenantId|否|``` Integer ```|租户ID|-
extraInfo|否|``` Extras ```|用于存放cartline ids, 不持久化|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-
### 13. 订单店铺配送上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderShopDeliverContext**



``` OrderShopDeliverContext ```

>订单店铺配送上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
expressType|否|``` String ```|物流类型: 1: 平台物流线上下单(顺丰/EMS)   2: 其它物流, 已经有单号|-
shopId|否|``` Long ```|商家id|-
userId|否|``` Long ```|买家id|-
corpCode|否|``` String ```|快递公司编号|-
corpName|否|``` String ```|快递公司名称|-
trackingNum|否|``` String ```|运单号|-
packageOrderId|否|``` Long ```|包裹单号|-
electronicPaperUrl|否|``` String ```|电子面单地址|-
outLogisticsTradeNo|否|``` String ```|物流公司交易流水号，呼叫快递的时候会有这个参数，打印面单需要用到这个参数|-
extra|否|``` Map<String,String> ```|拓展字段|-
tenantId|否|``` Integer ```|租户id|-
existPackageOrderLines|否|``` List<PackageOrderLine> ```|已经存在的发货单订单行|-
warehouseCode|否|``` String ```|仓库编号|-
updatedBy|否|``` String ```|操作人|-
reverseQuantityByOrderLineId|否|``` Map<Long,Integer> ```|每个订单行的申请逆向数量|-
shippedOrderLines|否|``` List<OrderLine> ```|本次发货发完的订单行集合|-
orders|否|``` List<Order> ```|-|-
currentPackageOrderLines|否|``` List<PackageOrderLine> ```|这次发货涉及到的所有发货子单最开始构建上下文的时候，对象中只有子订单行和数量这2个信息|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` PackageOrderLine ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-
### 14. 订单信息上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderInfoContext**



``` OrderInfoContext ```

>订单信息上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
orderPaging|否|``` Paging<Order> ```|-|-
purchaseOrderByOrderId|否|``` Map<Long,PurchaseOrder> ```|-|-
packageOrders|否|``` List<PackageOrder> ```|-|-
reverseOrderInfos|否|``` List<ReverseOrderInfo> ```|-|-

``` ReverseOrderInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
reverseOrderId|否|``` Long ```|逆向单号|-
reverseTypesEnum|否|``` ReverseTypesEnum ```|逆向单类型|-
reverseState|否|``` ReverseStates ```|状态|-
bizCode|否|``` String ```|业务标识|-
purchaseOrderId|否|``` Long ```|购物单号|-
orderId|否|``` Long ```|订单号|-
quantity|否|``` Integer ```|申请逆向数量|-
refundAmount|否|``` Long ```|申请退款金额|-
actualRefundAmount|否|``` Long ```|实际退款金额|-
actualRefundShippingAmount|否|``` Long ```|实际退运费金额|-
reverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|逆向单行列表|-
reverseOrderLineGroupInfoList|否|``` List<ReverseOrderLineGroupInfo> ```|逆向单行分组列表|-
buyerId|否|``` Long ```|买家ID|-
buyerName|否|``` String ```|买家名称|-
buyerMobile|否|``` String ```|买家手机号|-
shopId|否|``` Long ```|卖家ID|-
shopName|否|``` String ```|卖家名称|-
sellerId|否|``` Long ```|商家ID|-
originalPayChannel|否|``` String ```|支付渠道|-
refundChannel|否|``` String ```|退款渠道|-
refundSerialNo|否|``` String ```|退款流水|-
refundAccount|否|``` String ```|退款账号|-
refundAt|否|``` Date ```|退款时间|-
reasonId|否|``` Integer ```|逆向原因|-
reasonText|否|``` String ```|逆向原因|-
buyerNotes|否|``` ReverseUserNotesInfo ```|买家备注|-
sellerNotes|否|``` ReverseUserNotesInfo ```|卖家备注|-
warehouseCode|否|``` String ```|仓Code|-
storePhone|否|``` String ```|门店电话|-
storeName|否|``` String ```|门店名称|-
warehouseInfo|否|``` ReverseWarehouseInfo ```|仓信息|-
storeInfo|否|``` ReverseStoreInfo ```|门店信息|-
buyerShippingAddress|否|``` ReverseShippingAddressInfo ```|买家地址|-
buyerReturnLogistics|否|``` Logistics ```|买家物流|-
sellerReplacementLogistics|否|``` Logistics ```|卖家物流|-
syncState|否|``` Integer ```|同步时间|-
createdBy|否|``` String ```|创建者|-
updatedBy|否|``` String ```|更新者|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
hasSynced|否|``` Boolean ```|是否同步|-
isSuccessFinalStatus|否|``` Boolean ```|是否处于终态|-
isReplacementOosRefund|否|``` Boolean ```|是否换货无货|-

``` ReverseOrderLineInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|订单行ID|-
skuLineId|否|``` Long ```|逻辑订单行ID，同一sku因为寻源被拆分到两个仓而包含两个订单行|-
quantity|否|``` Integer ```|订单行上多少件商品发起逆向|-
initiateRefundAmount|否|``` Long ```|申请的退款金额|-
actualRefundAmount|否|``` Long ```|实际退款金额|-
actualRefundShippingAmount|否|``` Long ```|实际退运费金额|-
discountAmount|否|``` Long ```|订单行优惠分摊金额|-
memberPointsDeductAmount|否|``` Long ```|订单行分摊的积分数量|-
skuDetail|否|``` ReverseSkuDetailInfo ```|sku信息|-
bundleId|否|``` String ```|bundleId|-
masterId|否|``` Long ```|是否是bundle的主订单行|-

``` ReverseSkuDetailInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuId|-
skuCode|否|``` String ```|skuCode|-
skuName|否|``` String ```|skuName|-
skuAttributeList|否|``` List<ReverseSkuAttributeInfo> ```|销售属性|-
unitPrice|否|``` Long ```|单价|-
paidAmount|否|``` Long ```|实付金额|-
quantity|否|``` Integer ```|数量|-
mainImage|否|``` String ```|主图|-
itemId|否|``` Long ```|itemId|-
itemName|否|``` String ```|itemName|-
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-

``` ReverseSkuAttributeInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
attrKey|否|``` String ```|attrKey|-
attrVal|否|``` String ```|attrVal|-
unit|否|``` String ```|unit|-

``` ReverseOrderLineGroupInfo ```

>订单行组


参数名|必填|类型|描述|说明
---|---|---|---|---
masterReverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|bundle主行集合|-
slaveReverseOrderLineInfoList|否|``` List<ReverseOrderLineInfo> ```|bundle附属行集合，可能为空|-

``` Logistics ```

>物流信息


参数名|必填|类型|描述|说明
---|---|---|---|---
expressType|否|``` String ```|物流类型|-
companyCode|否|``` String ```|物流公司编码|-
companyName|否|``` String ```|物流公司名称|-
trackingNumber|否|``` String ```|物流编号|-
logisticFee|否|``` Long ```|物流费|-
trackInfoList|否|``` List<TrackInfo> ```|物流轨迹|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-

``` TrackInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
originTime|否|``` String ```|时间，原始格式|-
context|否|``` String ```|内容|-
formatTime|否|``` String ```|格式化后时间|-
areaCode|否|``` String ```|行政区域编码|-
areaName|否|``` String ```|行政区域名称|-
status|否|``` String ```|签收状态|-

``` ReverseWarehouseInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
name|否|``` String ```|name|-
code|否|``` String ```|code|-
shippingAddress|否|``` ReverseShippingAddressInfo ```|地址信息|-

``` ReverseShippingAddressInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|退货地址id|-
userId|否|``` Long ```|用户id|-
receiveUserName|否|``` String ```|收件人姓名|-
receiveUserDesc|否|``` String ```|收件人描述|-
phone|否|``` String ```|手机号|-
mobile|否|``` String ```|手机号|-
provinceId|否|``` Long ```|省份id|-
province|否|``` String ```|省份名|-
cityId|否|``` Long ```|城市id|-
city|否|``` String ```|城市名|-
regionId|否|``` Long ```|区县id|-
region|否|``` String ```|区县名|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道名|-
detail|否|``` String ```|详细地址|-
lat|否|``` String ```|-|-
lon|否|``` String ```|-|-
postcode|否|``` String ```|邮政编码|-
isDefault|否|``` Boolean ```|是否默认|-

``` ReverseTypesEnum ```

``` ReverseUserNotesInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
notes|否|``` String ```|备注|-
imageNoteList|否|``` List<String> ```|图片|-

``` ReverseStoreInfo ```

>【已废弃】未实际使用


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|退货门店id|-
categoryTemplateId|否|``` Long ```|类目模版id|-
storeCode|否|``` String ```|门店码|-
name|否|``` String ```|门店名称|-
status|否|``` Integer ```|状态|-
provinceId|否|``` Long ```|-|-
cityId|否|``` Long ```|-|-
regionId|否|``` Long ```|-|-
streetId|否|``` Long ```|-|-
fullAddress|否|``` String ```|-|-
detailAddress|否|``` String ```|-|-
contactDTOList|否|``` List<ReverseContactInfo> ```|-|-
supportOrder|否|``` Boolean ```|-|-
supportDelivery|否|``` Boolean ```|-|-
supportPickUp|否|``` Boolean ```|-|-
poiCode|否|``` String ```|-|-

``` ReverseContactInfo ```

参数名|必填|类型|描述|说明
---|---|---|---|---
contactName|否|``` String ```|-|-
contactMobile|否|``` String ```|-|-
contactDesc|否|``` String ```|-|-

``` ReverseStates ```

``` PackageOrder ```

>发货单【已废弃，目前未实际使用】


参数名|必填|类型|描述|说明
---|---|---|---|---
packageOrderId|否|``` Long ```|物流单号|-
createdAt|否|``` Date ```|创建时间|-
tenantId|否|``` Integer ```|租户id|-
outId|否|``` String ```|外部id|-
shop|否|``` Shop ```|卖家id|-
buyerInfo|否|``` Buyer ```|买家信息|-
logisticsInfo|否|``` Logistics ```|物流信息|-
shippingAddressInfo|否|``` ShippingAddress ```|收货信息|-
status|否|``` String ```|状态|-
confirmDeadline|否|``` Date ```|确认截止时间|-
trackInfo|否|``` String ```|追踪信息|-
packageOrderLines|否|``` List<PackageOrderLine> ```|包裹子单|-
updatedAt|否|``` Date ```|更新时间|-
confirmAt|否|``` Date ```|确认收货时间|-
version|否|``` Integer ```|乐观锁版本号|-
warehouseCode|否|``` String ```|仓库code|-
warehouseName|否|``` String ```|仓库名称|-
extras|否|``` Extras ```|-|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` PackageOrderLine ```

>包裹单行信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|skuID|-
skuCode|否|``` String ```|sku编码|-
skuName|否|``` String ```|sku名字|-
skuImage|否|``` String ```|sku图片|-
quantity|否|``` Integer ```|数量|-
orderLineId|否|``` Long ```|订单行id|-
displayFee|否|``` Long ```|展示的单价|-
skuAttr|否|``` String ```|sku销售属性|-
itemId|否|``` Long ```|商品id|-
totalDisplayFee|否|``` Long ```|商品金额合计|-
shipmentLineAbnormal|否|``` Integer ```|包裹内该商品的是否收货异常(0或者null为正常, 1为拒收)|-
trackingNumber|否|``` String ```|运单号|-
packageOrderLineId|否|``` Long ```|包裹单行id|-
packageOrderId|否|``` Long ```|包裹单id|-
isGift|否|``` Integer ```|是否为赠品|-
orderId|否|``` Long ```|订单id|-
status|否|``` String ```|状态|-
createDate|否|``` Date ```|创建时间|-
buyerId|否|``` Long ```|买家id|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` Paging<Order> ```

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-
### 15. 订单关单上下文

*参数路径*

**class io.terminus.parana.trade.order.server.process.context.OrderCloseContext**



``` OrderCloseContext ```

>订单关单上下文


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrder|否|``` PurchaseOrder ```|购物单|-
operator|否|``` Operator ```|操作者|-
updatedBy|否|``` String ```|更新人|-
bizCode|否|``` String ```|业务码（用于标识路由至哪系列流水线）|-
operation|否|``` String ```|行为码（用于标识路由至具体哪类流水线）|-

``` PurchaseOrder ```

>购物单信息


参数名|必填|类型|描述|说明
---|---|---|---|---
purchaseOrderId|否|``` Long ```|购物单id|-
tenantId|否|``` Integer ```|租户id|-
buyer|否|``` Buyer ```|买家信息|-
price|否|``` Price ```|价格信息|-
status|否|``` String ```|购物单状态|-
payStatus|否|``` String ```|支付状态|-
operateTime|否|``` OperateTime ```|操作时间|-
paymentOrders|否|``` List<PaymentOrder> ```|支付单列表|-
orders|否|``` List<Order> ```|订单信息|-
version|否|``` Integer ```|版本|-
outId|否|``` String ```|外部id|-
bizCode|否|``` String ```|业务编码|-
enableStatus|否|``` Integer ```|可见状态|-
tag|否|``` Long ```|标签|-
deviceSource|否|``` String ```|设备来源|-
updatedBy|否|``` String ```|更新者|-
extras|否|``` Extras ```|额外信息|-
isLastPay|否|``` Boolean ```|是否最后的支付|-
extras|否|``` Extras ```|-|-

``` Extras ```

参数名|必填|类型|描述|说明
---|---|---|---|---
extraMap|否|``` Map<String,String> ```|额外信息|-

``` Buyer ```

参数名|必填|类型|描述|说明
---|---|---|---|---
userId|否|``` Long ```|用户Id|-
subjectId|否|``` Long ```|买方主体Id|-
name|否|``` String ```|用户姓名|-
mobile|否|``` String ```|用户手机号|-
noticeMobile|否|``` String ```|通知手机号|-
shippingAddresses|否|``` List<ShippingAddress> ```|收货地址信息|-
invoices|否|``` List<SimplifyInvoice> ```|发票列表信息|-
checkedInvoice|否|``` SimplifyInvoice ```|选中的发票|-
extra|否|``` Map<String,String> ```|额外信息|-

``` SimplifyInvoice ```

>买家发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|发票信息id|-
userId|否|``` Long ```|用户id|-
invoiceKind|否|``` Integer ```|发票种类（普通，电子，特殊）{@link InvoiceKindEnum}|-
invoiceType|否|``` Integer ```|发票类型（未知，个人，企业，专票）{@link InvoiceReceiverTypeEnum}|-
title|否|``` String ```|发票抬头|-
content|否|``` String ```|发票内容|-
company|否|``` String ```|公司|-
taxpayerCode|否|``` String ```|税码|-
regAddress|否|``` String ```|收票地址|-
regPhone|否|``` String ```|收票手机|-
regBankName|否|``` String ```|收款银行名称|-
regBankAccount|否|``` String ```|收款银行账户|-
email|否|``` String ```|电子邮件|-
isDefault|否|``` Boolean ```|是否默认开票信息|-
invoiceMataJson|否|``` String ```|发票元数据信息|-
checkOk|否|``` Boolean ```|是否有效校验|-
shippingAddress|否|``` ShippingAddress ```|收票地址|-

``` ShippingAddress ```

>地址信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|id|-
userId|否|``` Long ```|用户ID|-
receiveUserName|否|``` String ```|收件人姓名|-
phone|否|``` String ```|电话|-
mobile|否|``` String ```|手机|-
provinceId|否|``` Long ```|省id|-
province|否|``` String ```|省|-
cityId|否|``` Long ```|市id|-
city|否|``` String ```|市|-
regionId|否|``` Long ```|区id|-
region|否|``` String ```|区|-
streetId|否|``` Long ```|街道id|-
street|否|``` String ```|街道|-
detail|否|``` String ```|详细地址|-
postcode|否|``` String ```|邮编|-
isDefault|否|``` Boolean ```|是否默认收货地址|-

``` Price ```

>价格


参数名|必填|类型|描述|说明
---|---|---|---|---
skuOriginTotalAmount|否|``` Long ```|商品原价总价|-
price|否|``` Long ```|采购单价（含税价）|-
noTaxPrice|否|``` Long ```|不含税单价|-
TaxPrice|否|``` Long ```|税额|-
tariff|否|``` Long ```|税率|-
skuAdjustAmount|否|``` Long ```|商品改价金额|-
shipFeeOriginAmount|否|``` Long ```|运费总价|-
shipFeeAdjustAmount|否|``` Long ```|运费改价金额|-
taxFeeOriginAmount|否|``` Long ```|税费总价|-
taxFeeAdjustAmount|否|``` Long ```|税费改价金额|-
paidAmount|否|``` Long ```|实付金额|-
skuDiscountTotalAmount|否|``` Long ```|商品金额总优惠|-
shipFeeDiscountTotalAmount|否|``` Long ```|运费金额总优惠|-
taxFeeDiscountTotalAmount|否|``` Long ```|税费金额总优惠|-

``` OperateTime ```

>操作时间


参数名|必填|类型|描述|说明
---|---|---|---|---
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
cancelledAt|否|``` Date ```|取消时间|-
payAt|否|``` Date ```|支付时间|-
payTimeOutAt|否|``` Date ```|支付超时时间|-
shippingAt|否|``` Date ```|发货时间|-
confirmAt|否|``` Date ```|收货时间|-
accomplishAt|否|``` Date ```|完成时间|-
refundAt|否|``` Date ```|退款|-

``` Order ```

>店铺订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderId|否|``` Long ```|订单编号|-
orderTitle|否|``` String ```|订单标题|-
purchaseOrderId|否|``` Long ```|购物单编号|-
orderLines|否|``` List<OrderLine> ```|关联的订单行列表|-
orderType|否|``` String ```|订单类型|-
payType|否|``` String ```|支付类型|-
tenantId|否|``` Integer ```|租户id|-
bizCode|否|``` String ```|业务类型|-
buyer|否|``` Buyer ```|买家信息|-
shop|否|``` Shop ```|商家信息|-
orderStatus|否|``` OrderStatus ```|订单状态|-
invoice|否|``` Invoice ```|发票信息|-
shippingAddress|否|``` ShippingAddress ```|收货地址信息|-
price|否|``` Price ```|价格|-
remark|否|``` Remark ```|留言备注|-
version|否|``` Integer ```|版本号|-
operateTime|否|``` OperateTime ```|操作时间|-
outId|否|``` String ```|-|-
deviceSource|否|``` String ```|-|-
enableStatus|否|``` Integer ```|-|-
tag|否|``` Long ```|-|-
updatedBy|否|``` String ```|-|-
sopInstanceCode|否|``` String ```|sop 实例编码|-
discounts|否|``` List<TradeNonMoneyDiscount> ```|非金额类型优惠|-
channelId|否|``` Long ```|渠道id|-
channelName|否|``` String ```|渠道名称|-
channelCode|否|``` String ```|渠道编码|-
sellerId|否|``` Long ```|商家(供应商)id（货主id）|-
sellerName|否|``` String ```|商家(供应商)名称（货主名称）|-
usePlatformWms|否|``` Boolean ```|是否使用wms|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
upstreamOrderId|否|``` Long ```|上游单据ID|-
upstreamOrderType|否|``` String ```|上游单据类型|-
purchasingOrganizationName|否|``` String ```|采购组织|-
receivingWarehouseCode|否|``` String ```|收货仓库编码|-
receivingWarehouseName|否|``` String ```|收货仓库名称|-
purchasingStaffName|否|``` String ```|采购员|-
purchasingEntityId|否|``` String ```|采购实体Id|-
purchasingEntityName|否|``` String ```|采购实体名称|-
createdWay|否|``` String ```|创建方式|-
extras|否|``` Extras ```|-|-

``` TradeNonMoneyDiscount ```

参数名|必填|类型|描述|说明
---|---|---|---|---
activityId|否|``` Long ```|活动编号|-
feature|否|``` String ```|-|-
activityCode|否|``` String ```|活动编码|-
activityOutId|否|``` String ```|活动外部编码|-
shopId|否|``` Long ```|店铺id|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
productCode|否|``` String ```|优惠类型|-
promotionGroup|否|``` PromotionGroup ```|优惠归组|-
benefitId|否|``` Long ```|权益id|-
resourceId|否|``` String ```|资源id|-
activityName|否|``` String ```|活动名称|-
costRatio|否|``` String ```|分摊比例|-
virtualPayRatio|否|``` String ```|虚拟分摊比例|-

``` PromotionGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedLines|否|``` Set<String> ```|相关行|-
giftGroups|否|``` List<GiftGroup> ```|赠品明细|-

``` GiftGroup ```

参数名|必填|类型|描述|说明
---|---|---|---|---
matchedDetailLines|否|``` Set<String> ```|命中明细行集合|-
freeGifts|否|``` Set<FreeGift> ```|赠品集合|-
limitedQuantity|否|``` Integer ```|限制数量|-

``` FreeGift ```

参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|订单行id|-
skuId|否|``` Long ```|商品id|-
expectedQuantity|否|``` Integer ```|应送数量|-
quantity|否|``` Integer ```|实际赠送数量|-
price|否|``` Long ```|价格|-
extra|否|``` Map<String,String> ```|额外信息|-

``` Shop ```

>店铺信息


参数名|必填|类型|描述|说明
---|---|---|---|---
id|否|``` Long ```|店铺id|-
tenantId|否|``` Integer ```|租户id|-
outerId|否|``` String ```|外部id|-
userId|否|``` Long ```|用户id|-
userName|否|``` String ```|用户名|-
name|否|``` String ```|店铺名|-
status|否|``` Integer ```|状态|-
type|否|``` Integer ```|类型|-
phone|否|``` String ```|电话|-
businessId|否|``` Long ```|businessId|-
imageUrl|否|``` String ```|图片地址|-
address|否|``` String ```|地址|-
email|否|``` String ```|邮箱|-
tags|否|``` Long ```|标签|-
buyerNote|否|``` String ```|买家留言|-
isSelfMention|否|``` Boolean ```|是否支持自提|-
extra|否|``` Map<String,String> ```|额外信息|-
sellerId|否|``` Long ```|供方ID|-
sellerName|否|``` String ```|供方名称|-
sellerCode|否|``` String ```|供方编码|-
usePlatformWms|否|``` Boolean ```|是否使用WMS|-
usePlatformOms|否|``` Boolean ```|是否使用OMS|-
usePlatformTms|否|``` Boolean ```|是否使用TMS|-
channelId|否|``` Long ```|渠道id|-
channelCode|否|``` String ```|渠道编码|-
channelName|否|``` String ```|渠道名称|-

``` OrderLine ```

>商品订单


参数名|必填|类型|描述|说明
---|---|---|---|---
orderLineId|否|``` Long ```|商品订单编号|-
orderId|否|``` Long ```|订单编号|-
tenantId|否|``` Integer ```|租户id|-
purchaseOrderId|否|``` Long ```|购物单编号|-
ownerOrderLineId|否|``` Long ```|所属订单行Id(组合商品中主商品的OrderLineId)<p>普通商品ownerOrderLineId为NULL组合商品的master订单行ownerOrderLineId值就是master订单行的orderLineId，既自身的订单行ID组合商品的bom订单行ownerOrderLineId值为它所属master订单行的orderLineId|-
shop|否|``` Shop ```|商家|-
warehouseCodePlan|否|``` String ```|计划发货仓库id|-
warehouseCodeActual|否|``` String ```|实际发货仓库id|-
buyer|否|``` Buyer ```|买家|-
bizCode|否|``` String ```|业务类型|-
sku|否|``` Sku ```|商品信息|-
material|否|``` Material ```|物料信息|-
quantity|否|``` Integer ```|数量|-
unit|否|``` String ```|单位|-
shipCompleteFlag|否|``` Boolean ```|发货完成标记|-
reachedCompeteFlag|否|``` Boolean ```|收货完成标记|-
shipExecutedQuantity|否|``` Integer ```|已发货数量|-
receivedQuantity|否|``` Integer ```|已收货数量|-
orderLineStatus|否|``` OrderStatus ```|状态|-
discounts|否|``` List<TradeDiscount> ```|优惠明细|-
version|否|``` Integer ```|版本|-
enableStatus|否|``` Integer ```|可见状态|-
operateTime|否|``` OperateTime ```|操作时间|-
deviceSource|否|``` String ```|设备类型|-
tag|否|``` Long ```|标记|-
masterId|否|``` Long ```|-|-
updatedBy|否|``` String ```|更新时间|-
price|否|``` Price ```|价格|-
skuLineId|否|``` Long ```|逻辑子单id|-
outId|否|``` String ```|外部子单号|-
bundleId|否|``` String ```|商品组id|-
orderLineType|否|``` Integer ```|-|-
childOrderLines|否|``` List ```|配方订单行|-
planDeliveryAt|否|``` Date ```|计划交货时间|-
sellerName|否|``` String ```|供应商名称|-
upstreamPlanLineIds|否|``` List<Long> ```|-|-
extras|否|``` Extras ```|-|-

``` Material ```

>物料信息


参数名|必填|类型|描述|说明
---|---|---|---|---
materialId|否|``` Long ```|物料id|-
materialCode|否|``` String ```|物料编码|-
materialName|否|``` String ```|物料名称|-
attributes|否|``` String ```|物料规格|-
quantity|否|``` Long ```|物料数量|-
quantityUnit|否|``` String ```|物料单位|-

``` TradeDiscount ```

>优惠明细


参数名|必填|类型|描述|说明
---|---|---|---|---
lineId|否|``` String ```|行id|-
activityId|否|``` Long ```|活动编号|-
shopId|否|``` Long ```|店铺id|-
activityCode|否|``` String ```|活动编码|-
type|否|``` String ```|优惠类型:NONE(0),SKU_FEE(1),SHIPPING_FEE(2),TAX_FEE(3)|-
level|否|``` String ```|优惠级别:NONE(0),SKU(1),SHOP(2),PLATFORM(3)|-
totalAmount|否|``` Long ```|优惠总的金额|-
occupiedAmount|否|``` Long ```|优惠金额分摊|-
costRatio|否|``` String ```|分摊比例|-
effectQuantity|否|``` Long ```|优惠影响的数量|-
deductAmount|否|``` Long ```|抵扣数量 如果是积分 存的均摊的积分数量|-
deductTotalAmount|否|``` Long ```|抵扣数量 如果是积分 存的总的使用积分数量|-
action|否|``` String ```|优惠动作类型|-
campaignId|否|``` Long ```|权益id这个暂时没有用到|-
feature|否|``` String ```|权益id|-

``` Sku ```

>商品信息


参数名|必填|类型|描述|说明
---|---|---|---|---
skuId|否|``` Long ```|商品skuId|-
itemId|否|``` Long ```|商品itemId|-
skuCode|否|``` String ```|商品skuCode|-
mainImg|否|``` String ```|主图|-
attrs|否|``` String ```|销售属性|-
type|否|``` Integer ```|商品类型|-
skuName|否|``` String ```|sku名称|-
itemName|否|``` String ```|商品名称|-
skuExtra|否|``` Extras ```|sku额外信息|-

``` OrderStatus ```

>订单状态信息


参数名|必填|类型|描述|说明
---|---|---|---|---
payStatus|否|``` String ```|支付状态|-
deliveryStatus|否|``` String ```|发货状态|-
receiveStatus|否|``` String ```|收货状态|-
reverseStatus|否|``` String ```|退货状态|-
refundStatus|否|``` String ```|退款状态|-
commentStatus|否|``` String ```|评价状态|-

``` Remark ```

>留言备注


参数名|必填|类型|描述|说明
---|---|---|---|---
buyerRemark|否|``` String ```|买家留言|-
sellerRemark|否|``` String ```|卖家留言|-

``` Invoice ```

>发票信息


参数名|必填|类型|描述|说明
---|---|---|---|---
invoiceItemId|否|``` Long ```|-|-
tenantId|否|``` Integer ```|-|-
orderId|否|``` Long ```|-|-
shopId|否|``` Long ```|-|-
buyerId|否|``` Long ```|-|-
invoiceCategory|否|``` String ```|发票种类：普通、电子、专用  必填|-
invoiceType|否|``` String ```|发票类型：蓝票，红票  必填|-
invoiceReceiverType|否|``` String ```|发票抬头类型: 个人、企业  必填|-
invoiceStatus|否|``` String ```|发票状态：待开、已开、失败  必填|-
title|否|``` String ```|发票抬头 必填|-
content|否|``` String ```|发票内容  必填|-
taxerIdentifier|否|``` String ```|纳税人识别号  必填|-
regAddress|否|``` String ```|注册地址|-
regPhone|否|``` String ```|注册电话|-
regBankName|否|``` String ```|开户银行名称|-
regBankAccount|否|``` String ```|开户银行账号|-
taxCode|否|``` String ```|税收编码  必填|-
taxRate|否|``` String ```|税率  必填|-
issueAt|否|``` Date ```|开票时间|-
invoiceValue|否|``` Long ```|发票金额  必填|-
taxValue|否|``` Long ```|税额|-
isValid|否|``` Integer ```|该发票是否有效|-
invoiceCode|否|``` String ```|发票代码|-
invoiceId|否|``` String ```|开票接口返回的发票ID|-
downloadUrl|否|``` String ```|下载地址|-
invoiceSerialNo|否|``` String ```|-|-
isDefault|否|``` Boolean ```|-|-
currInvoiceDisplayStatus|否|``` String ```|当前发票信息展示状态|-
errorMsg|否|``` String ```|开票失败时的错误原因|-
version|否|``` Integer ```|乐观锁|-
shippingAddress|否|``` ShippingAddress ```|收货地址|-
extras|否|``` Extras ```|-|-

``` PaymentOrder ```

>支付单info


参数名|必填|类型|描述|说明
---|---|---|---|---
paymentOrderId|否|``` Long ```|支付单id|-
tenantId|否|``` Integer ```|支付单id|-
purchaseOrderId|否|``` Long ```|支付单id|-
bizCode|否|``` String ```|bizCode|-
createdAt|否|``` Date ```|创建时间|-
updatedAt|否|``` Date ```|更新时间|-
completedAt|否|``` Date ```|完成时间|-
buyer|否|``` Buyer ```|买家信息|-
paidAmount|否|``` Long ```|实付金额|-
handlingAmount|否|``` Long ```|手续费|-
originAmount|否|``` Long ```|应付金额|-
totalStages|否|``` Integer ```|总支付阶段数|-
stage|否|``` Integer ```|该笔支付单对应的支付阶段|-
account|否|``` String ```|支付账号|-
payAt|否|``` Date ```|支付时间|-
paymentMethod|否|``` String ```|支付方式: 在线支付/货到付款|-
payChannel|否|``` String ```|支付渠道|-
payChannelEn|否|``` String ```|支付渠道英文名称|-
bankNo|否|``` String ```|银行编号|-
bankName|否|``` String ```|银行名称|-
status|否|``` String ```|状态|-
requiredStartAt|否|``` Date ```|开始时间|-
requiredEndAt|否|``` Date ```|结束时间|-
externalTradeNo|否|``` String ```|外部流水|-
internalTradeNo|否|``` String ```|内部流水|-
extra|否|``` String ```|extras json string|-
extraMap|否|``` Map<String,String> ```|extras map|-
tag|否|``` Long ```|标签|-
version|否|``` Integer ```|版本|-

``` Operator ```

参数名|必填|类型|描述|说明
---|---|---|---|---
operatorId|否|``` Long ```|操作人编号|-
operatorRole|否|``` String ```|主体角色|-
parentId|否|``` Long ```|所属主账号id, 对于卖家而言就是shop id对于仓库而言, 就是 warehouse_code|-
