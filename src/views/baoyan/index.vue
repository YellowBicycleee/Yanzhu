<template>
  <div class="wrapper">
    <div
      class="query-box"
    >
      <div class="search-box">
        <el-form :inline="true" label-width="80px">
          <el-form-item label="学校">
            <el-input v-model="query.cname" placeholder="请输入学校" style="margin-right: 20px; width: 177px" clearable />
          </el-form-item>
          <el-form-item label="学院">
            <el-input v-model="query.sname" placeholder="请输入学校" style="margin-right: 20px; width: 177px" clearable />
          </el-form-item>
          <el-form-item label="年份">
            <el-date-picker
              v-model="query.year"
              type="year"
              value-format="yyyy"
              placeholder="选择年"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="queryCustomList">查询</el-button>
            <el-button @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <div class="table-box">
      <el-table
        ref="table"
        v-loading="loading"
        :data="list4Show"
        style="width: 100%;"
        border
        stripe
        height="100%"
      >
        <el-table-column
          type="index"
          align="center"
          label="序"
          width="55"
          fixed
        />
        <el-table-column
          prop="cname"
          label="学校"
          width="200"
          show-overflow-tooltip
        />
        <el-table-column
          prop="sname"
          label="学院名称"
          width="200"
          show-overflow-tooltip
        />
        <el-table-column
          prop="instructor"
          label="批次"
          width="180"
          show-overflow-tooltip
        />
        <el-table-column
          prop="rate"
          label="学生排名"
          width="180"
          align="center"
          show-overflow-tooltip
        />
        <el-table-column
          prop="year"
          label="年份"
          width="180"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="uri"
          label="学校官网"
          show-overflow-tooltip
        >
          <template slot-scope="scope">
            <el-link :href="scope.row.uri" target="_blank" type="primary">{{ scope.row.uri }}</el-link>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <pagination v-show="total>0" :total="total" :page.sync="pageInfo.page" :limit.sync="pageInfo.size" />
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { getBaoYanList } from '@/api/table'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ]),
    list4Show() {
      const { page, size } = this.pageInfo

      return this.list.slice((page - 1) * size, page * size)
    }
  },
  components: {
    Pagination
  },
  data() {
    return {
      query: {},
      pageInfo: {
        page: 1,
        size: 20
      },
      loading: false,
      list: [],
      total: 0
    }
  },
  mounted() {
    this.queryCustomList()
  },
  methods: {
    reset() {
      this.query = {}
      this.queryCustomList()
    },
    queryCustomList() {
      console.log(this.query, '---------')
      this.loading = true
      const { cname, sname, year } = this.query || {}
      console.log(cname, sname, year)
      getBaoYanList({ cname, sname, year }).then(res => {
        console.log(res)
        this.list = res
        this.total = res.length
        this.loading = false
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.wrapper {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  padding: 30px 20px;
  background-color: #f0f2f5;
  .query-box {
    margin: 20px 0;
    display: flex;
    justify-content: space-between;
    background: #fff;
    padding: 18px 16px 0;
    align-items: flex-start;
    .search-box {
      display: flex;
      flex: 1;
    }
    .selector {
      margin-left: 20px;
    }
  }
  .table-box {
    flex: 1;
    padding: 16px;
    background: #fff;
    overflow: hidden;
  }
}
</style>

