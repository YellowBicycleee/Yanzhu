<template>
  <el-dialog
    title="注册账户"
    :visible="visible"
    width="30%"
    :before-close="closeDialog"
    append-to-body
  >
    <el-form ref="ruleForm" :model="ruleForm" status-icon :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="account">
        <el-input v-model="ruleForm.account" type="account" autocomplete="off" />
      </el-form-item>
      <el-form-item label="新密码" prop="password">
        <el-input v-model="ruleForm.password" type="password" autocomplete="off" />
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
import { registerUser } from '@/api/user'
export default {
  props: {
    visible: {
      type: Boolean
    },
    resetToken: {
      type: Function,
      require: true,
      default: Function
    }
  },
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
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        account: '',
        password: '',
        checkPass: ''
      },
      rules: {
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        account: [
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
          registerUser({
            account: this.ruleForm.account,
            password: this.ruleForm.password
          }).then(() => {
            this.$message({
              message: '注册成功，请登录平台',
              type: 'success'
            })
            this.resetToken()
            this.closeDialog()
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
