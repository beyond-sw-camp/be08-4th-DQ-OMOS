<template>
  <Dialog :visible="visible" pt:root:class="!border-0 !bg-transparent" pt:mask:class="backdrop-blur-md"
    :style="{ width: '20vw' }">
    <template #container="{ closeCallback }">
      <div class="flex flex-col px-8 py-6 gap-3 rounded-xl shadow-lg !bg-white">
        <h1 class="!text-gray-800 text-2xl font-semibold">로그인</h1>
        <Divider />
        <form action="">

        </form>
        <div class="inline-flex flex-col gap-2">
          <label for="email" class="!text-gray-800 font-medium">이메일</label>
          <InputText id="username"
            class="!bg-gray-100 !border-0 !p-3 !text-gray-800 rounded-md focus:!ring-2 focus:!ring-gray-400 w-full"
            placeholder="Email">
          </InputText>
        </div>

        <div class="inline-flex flex-col gap-2">
          <label for="password" class="!text-gray-800 font-medium">비밀번호</label>
          <InputText id="password"
            class="!bg-gray-100 !border-0 !p-3 !text-gray-800 rounded-md focus:!ring-2 focus:!ring-gray-400 w-full"
            type="password" placeholder="Password"></InputText>
        </div>

        <div class="flex flex-col items-center gap-4">
          <div class="flex items-center gap-2 w-full">
            <Button label="취소" @click="closeDialog" text
              class="!text-gray-800 !p-3 w-full !border !border-gray-300 hover:!bg-gray-200 rounded-md"></Button>
            <Button label="로그인" @click="closeDialog" text
              class="!text-gray-800 !p-3 w-full !border !border-gray-300 hover:!bg-gray-200 rounded-md"></Button>
          </div>

          <div class="flex flex-col items-center gap-2">
            <a href="#" class="text-gray-400 text-sm hover:text-gray-800">회원가입</a>
            <a href="#" class="text-gray-400 text-sm hover:text-gray-800">비밀번호 찾기</a>
          </div>
        </div>
      </div>
    </template>
  </Dialog>
</template>

<script setup>
import { defineProps, defineEmits, watch } from 'vue';
import { useLayout } from '@/layout/composables/layout';
const { getPrimary, getSurface, isDarkTheme } = useLayout();

const props = defineProps({
  visible: Boolean,
});

const emit = defineEmits(['update:visible']);

const closeDialog = () => {
  emit('update:visible', false);
};

watch([getPrimary, getSurface, isDarkTheme], () => {
  chartData.value = setChartData();
  chartOptions.value = setChartOptions();
});
</script>
