<template>
    <div class="addflower">
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>商品管理</el-breadcrumb-item>
            <el-breadcrumb-item>添加商品</el-breadcrumb-item>
        </el-breadcrumb>

        <el-card class="box-card">

            <el-form inline :model="flowerinfo" label-width="90px">
                <el-form-item label="鲜花标题：">
                    <el-input v-model="flowerinfo.title" placeholder="请输入鲜花标题"></el-input>
                </el-form-item>
                <el-form-item label="花语：">
                    <el-input v-model="flowerinfo.language" placeholder="请输入花语"></el-input>
                </el-form-item>
                <el-form-item label="上下架：">
                    <el-switch
                            @change="flowerStatusChange"
                            v-model="status"
                            active-color="#13ce66"
                            inactive-color="#ff4949"
                            active-text="上架"
                            inactive-text="下架">
                    </el-switch>
                </el-form-item>
                <el-form-item label="材料：">
                    <el-input v-model="flowerinfo.material" placeholder="请输入鲜花材料"></el-input>
                </el-form-item>
                <el-form-item label="包装：">
                    <el-input v-model="flowerinfo.pack" placeholder="请输入包装材料"></el-input>
                </el-form-item>
                <el-form-item label="存放仓库：">
                    <el-select size="small" v-model="flowerinfo.warehouseId" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                v-model="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="入库数量：">
                    <el-input-number v-model="flowerinfo.stock" :min="0" :step="1"></el-input-number>
                </el-form-item>


                <el-form-item label="销售价格：" label-width="100px">
                    <el-input-number v-model="flowerinfo.price" :precision="2" :min="0" :step="1.00"></el-input-number>
                </el-form-item>


                <el-form-item label="鲜花类别：" label-width="100px">
                    <el-select size="small" v-model="flowerinfo.sortId" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="鲜花用途：" style="display: block">
                    <el-select size="small" v-model="flowerinfo.sortId" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="鲜花正图：">
                    <div class="upload">
                        <img @click="$refs.uploadRef.click()" v-if="imageUrl!=''" :src="imageUrl" class="cover">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        <input type="file" ref="uploadRef" style="display: none" @change="inputFileChange">
                    </div>
                </el-form-item>

            </el-form>
            <!--上传详细图片表单-->
            <el-form inline label-width="90px">
                <el-form-item label="详细图片：">
                    <div class="pictureInfo">
                        <div class="picture" v-for="(item,index) in picturepreviews" :key="index">
                            <img :src="item" class="cover">
                        </div>
                        <div @click="$refs.pictureInfo.click()" class="upload">
                            <i class="el-icon-plus avatar-uploader-icon"></i>
                        </div>
                        <input name="picture" id="picture" style="display: none"
                               @change="flowerPictureChange" type="file" ref="pictureInfo"/>
                    </div>
                </el-form-item>
            </el-form>
            <!--产品说明-->
            <el-form label-width="90px">
                <el-form-item label="产品说明：">
                    <el-input type="textarea" v-model="flowerinfo.details" placeholder="产品说明" rows="4"></el-input>
                </el-form-item>
                <el-button @click="uploadClick">上传</el-button>
            </el-form>
        </el-card>

    </div>
</template>

<script>
    export default {
        data() {
            return {
                pictures: [],
                picturepreviews: [],
                dialogImageUrl: '',
                dialogVisible: false,
                imageUrl: '/getImage/images/aaa.jpg',
                options: [{label: "玫瑰仓库", value: 1}],
                flowerinfo: {price: 1, stock: 0, buyCount: 0},
                status: 1,
            }
        },
        methods: {
            // 上下架
            flowerStatusChange(val) {
                this.flowerinfo.status
                console.log(status)
            },       //封面图发生改变时
            inputFileChange() {
                console.log(this.$refs.uploadRef.files[0])
                this.imageUrl = URL.createObjectURL(this.$refs.uploadRef.files[0])  //创建一个虚拟路径,用来显示

            },// 详情图片
            flowerPictureChange() {
                this.pictures.push(this.$refs.pictureInfo.files[0])
                this.picturepreviews.push(URL.createObjectURL(this.$refs.pictureInfo.files[0]))

            },
            uploadClick() {
                this.$axios({
                    url: '/api/flower/upload',
                    method: 'post',
                    data: new FormData(this.pictures)
                }).then(result => {
                    console.log(result)
                })
            }
        }
    }
</script>

<style scoped>
    .box-card {
        margin-top: 10px;
    }

    /*   鲜花正图样式 */
    .upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .upload:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 128px;
        height: 128px;
        line-height: 128px;
        text-align: center;
    }

    .cover {
        width: 128px;
        height: 128px;
        display: block;
    }

    /*    详细图片 */
    .pictureInfo {
        display: flex;
    }

    .pictureInfo .picture {
        margin-right: 1px;
        padding: 1px;
        border: 1px solid #d9d9d9;
        border-radius: 6px;
    }
</style>