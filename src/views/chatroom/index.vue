<template>
  <div class="wrapper">
    <div class="inner">
      <div style="flex:1; overflow: hidden;">
        <el-scrollbar style="width: 100%;height:100%;">
          <div>
            <div v-for="(item, index) in chatList" :key="index" :class="[item.type === 'A' ? 'greyBg' : '', 'chat-item']">
              <div class="avator">
                <el-avatar shape="square" size="medium" :src="item.type === 'Q' ? myImg : robotImg" />
              </div>
              <div class="content">{{ item.msg }}</div>
            </div>
          </div>
        </el-scrollbar>
      </div>
      <div class="chat-input">
        <div class="input">
          <el-input v-model="content" placeholder="请输入您的问题" />
        </div>
        <div class="btn">
          <el-button type="primary" :disabled="isDisabled" @click="onSubmit">查询</el-button>
        </div>
      </div>
    </div>
  </div></template>

<script>
import { qaQuestion } from '@/api/chat'
import myImg from '@/assets/user.gif'
import robotImg from '@/assets/robot.png'
export default {
  data() {
    return {
      content: '',
      myImg,
      robotImg,
      chatList: []
    }
  },
  computed: {
    isDisabled() {
      return !this.content || this.content.trim() === ''
    }
  },
  methods: {
    onSubmit() {
      const qMessage = {
        type: 'Q',
        msg: this.content
      }
      this.chatList = [...this.chatList, qMessage]

      qaQuestion(this.content).then(res => {
        const aMessage = {
          type: 'A',
          msg: res
        }
        this.content = ''
        setTimeout(() => {
          this.chatList = [...this.chatList, aMessage]
        }, 200)
      })
    }
  }
}
</script>

<style scoped lang="scss">
.wrapper {
  height: 100%;
  background-color: #f0f2f5;
  padding: 50px 50px;
  width: 100%;
  .inner {
    border-radius: 12px;
    background: #fff;
    width: 80%;
    max-width: 800px;
    margin: 0 auto;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 30px 20px;
    overflow: hidden;
  }
  .chat-list {
    height: 100%;
    overflow-y: auto;
  }
  .chat-input {
    display: flex;
    .input {
      flex: 1;
    }
    .btn {
      margin-left: 20px;
    }

  }

  .chat-item {
    padding: 20px;
    display: flex;
    border-bottom: 1px solid #eee;
    &.greyBg {
      background: #f5f7fa;
    }
    .avator {
      margin-right: 18px;
    }
    .content {
      flex: 1;
    }
  }

}
::v-deep {
.el-scrollbar__wrap {
  overflow: auto;
}

}
</style>

