package com.taobao.luaview.fun.binder.ui;

import com.taobao.luaview.fun.base.BaseFunctionBinder;
import com.taobao.luaview.fun.base.BaseVarArgUICreator;
import com.taobao.luaview.fun.mapper.ui.UILoadingViewMethodMapper;
import com.taobao.luaview.view.LVLoadingView;
import com.taobao.luaview.view.interfaces.ILVView;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.LibFunction;

/**
 * 菊花（非对话框）
 * @author song
 */
public class UILoadingViewBinder extends BaseFunctionBinder {

    public UILoadingViewBinder() {
        super("LoadingIndicator");
    }

    @Override
    public Class<? extends LibFunction> getMapperClass() {
        return UILoadingViewMethodMapper.class;
    }

    @Override
    public LuaValue createCreator(LuaValue env, LuaValue metaTable) {
        return new BaseVarArgUICreator(env.checkglobals(), metaTable) {
            @Override
            public ILVView createView(Globals globals, LuaValue metaTable, Varargs varargs) {
                return new LVLoadingView(globals, metaTable, varargs);
            }
        };
    }

}
