<template>
  <el-dialog
    title="修改密码"
    :visible="visible"
    width="30%"
    :before-close="closeDialog"
    append-to-body
  >
    <el-form ref="ruleForm" :model="ruleForm" status-icon :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="account">
        <el-input :value="name" type="account" autocomplete="off" read-only />
      </el-form-item>
      <el-form-item label="旧密码" prop="oldPassword">
        <el-input v-model="ruleForm.oldPassword" type="password" autocomplete="off" />
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword">
        <el-input v-model="ruleForm.newPassword" type="password" autocomplete="off" />
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input v-model="ruleForm.checkPass" type="password" autocomplete="off" />
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="closeDialog">取 消</el-button>
      <el-button type="primary" @click="submitForm('ruleForm')">提 交</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { resetPass } from '@/api/user'
import { mapGetters } from 'vuex'
import { getName } from '@/utils/auth'
export default {
  props: {
    visible: {
      type: Boolean
    },
    logout: {
      type: Function,
      require: true,
      default: Function
    }
  },
  // computed: {
  //   ...mapGetters([
  //     'name'
  //   ])
  // },
  data() {
    const validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    const validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm.newPassword) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      name: getName(),
      ruleForm: {
        newPassword: '',
        checkPass: '',
        oldPassword: ''
      },
      rules: {
        newPassword: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        oldPassword: [
          { require: true, trigger: 'blue' }
        ]
      }
    }
  },
  methods: {
    closeDialog() {
      this.$emit('close-dialog')
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          resetPass({
            account: this.name,
            oldPassword: this.ruleForm.oldPassword,
            newPassword: this.ruleForm.newPassword
          }).then(() => {
            this.$message({
              message: '密码修改成功，请重新登录',
              type: 'success'
            })
            setTimeout(() => {
              this.logout()
            }, 200)
          })
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
