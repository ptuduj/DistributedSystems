// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HashTabOperation.proto

package protos;

public final class HashTabOperationProtos {
  private HashTabOperationProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface HashTabOperationOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // required .HashTabOperation.OperationType type = 1;
    boolean hasType();
    protos.HashTabOperationProtos.HashTabOperation.OperationType getType();
    
    // required int32 value = 2;
    boolean hasValue();
    int getValue();
    
    // required string key = 3;
    boolean hasKey();
    String getKey();
  }
  public static final class HashTabOperation extends
      com.google.protobuf.GeneratedMessage
      implements HashTabOperationOrBuilder {
    // Use HashTabOperation.newBuilder() to construct.
    private HashTabOperation(Builder builder) {
      super(builder);
    }
    private HashTabOperation(boolean noInit) {}
    
    private static final HashTabOperation defaultInstance;
    public static HashTabOperation getDefaultInstance() {
      return defaultInstance;
    }
    
    public HashTabOperation getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protos.HashTabOperationProtos.internal_static_HashTabOperation_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protos.HashTabOperationProtos.internal_static_HashTabOperation_fieldAccessorTable;
    }
    
    public enum OperationType
        implements com.google.protobuf.ProtocolMessageEnum {
      CONTAINS(0, 0),
      GET(1, 1),
      PUT(2, 2),
      RMV(3, 3),
      ACK(4, 4),
      NACK(5, 5),
      ;
      
      public static final int CONTAINS_VALUE = 0;
      public static final int GET_VALUE = 1;
      public static final int PUT_VALUE = 2;
      public static final int RMV_VALUE = 3;
      public static final int ACK_VALUE = 4;
      public static final int NACK_VALUE = 5;
      
      
      public final int getNumber() { return value; }
      
      public static OperationType valueOf(int value) {
        switch (value) {
          case 0: return CONTAINS;
          case 1: return GET;
          case 2: return PUT;
          case 3: return RMV;
          case 4: return ACK;
          case 5: return NACK;
          default: return null;
        }
      }
      
      public static com.google.protobuf.Internal.EnumLiteMap<OperationType>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static com.google.protobuf.Internal.EnumLiteMap<OperationType>
          internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<OperationType>() {
              public OperationType findValueByNumber(int number) {
                return OperationType.valueOf(number);
              }
            };
      
      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(index);
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return protos.HashTabOperationProtos.HashTabOperation.getDescriptor().getEnumTypes().get(0);
      }
      
      private static final OperationType[] VALUES = {
        CONTAINS, GET, PUT, RMV, ACK, NACK, 
      };
      
      public static OperationType valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        return VALUES[desc.getIndex()];
      }
      
      private final int index;
      private final int value;
      
      private OperationType(int index, int value) {
        this.index = index;
        this.value = value;
      }
      
      // @@protoc_insertion_point(enum_scope:HashTabOperation.OperationType)
    }
    
    private int bitField0_;
    // required .HashTabOperation.OperationType type = 1;
    public static final int TYPE_FIELD_NUMBER = 1;
    private protos.HashTabOperationProtos.HashTabOperation.OperationType type_;
    public boolean hasType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public protos.HashTabOperationProtos.HashTabOperation.OperationType getType() {
      return type_;
    }
    
    // required int32 value = 2;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int value_;
    public boolean hasValue() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public int getValue() {
      return value_;
    }
    
    // required string key = 3;
    public static final int KEY_FIELD_NUMBER = 3;
    private java.lang.Object key_;
    public boolean hasKey() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public String getKey() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          key_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    private void initFields() {
      type_ = protos.HashTabOperationProtos.HashTabOperation.OperationType.CONTAINS;
      value_ = 0;
      key_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasValue()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasKey()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, type_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, value_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getKeyBytes());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, type_.getNumber());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, value_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getKeyBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static protos.HashTabOperationProtos.HashTabOperation parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protos.HashTabOperationProtos.HashTabOperation prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements protos.HashTabOperationProtos.HashTabOperationOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return protos.HashTabOperationProtos.internal_static_HashTabOperation_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return protos.HashTabOperationProtos.internal_static_HashTabOperation_fieldAccessorTable;
      }
      
      // Construct using protos.HashTabOperationProtos.HashTabOperation.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        type_ = protos.HashTabOperationProtos.HashTabOperation.OperationType.CONTAINS;
        bitField0_ = (bitField0_ & ~0x00000001);
        value_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        key_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return protos.HashTabOperationProtos.HashTabOperation.getDescriptor();
      }
      
      public protos.HashTabOperationProtos.HashTabOperation getDefaultInstanceForType() {
        return protos.HashTabOperationProtos.HashTabOperation.getDefaultInstance();
      }
      
      public protos.HashTabOperationProtos.HashTabOperation build() {
        protos.HashTabOperationProtos.HashTabOperation result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private protos.HashTabOperationProtos.HashTabOperation buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        protos.HashTabOperationProtos.HashTabOperation result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public protos.HashTabOperationProtos.HashTabOperation buildPartial() {
        protos.HashTabOperationProtos.HashTabOperation result = new protos.HashTabOperationProtos.HashTabOperation(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.type_ = type_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.value_ = value_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.key_ = key_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof protos.HashTabOperationProtos.HashTabOperation) {
          return mergeFrom((protos.HashTabOperationProtos.HashTabOperation)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(protos.HashTabOperationProtos.HashTabOperation other) {
        if (other == protos.HashTabOperationProtos.HashTabOperation.getDefaultInstance()) return this;
        if (other.hasType()) {
          setType(other.getType());
        }
        if (other.hasValue()) {
          setValue(other.getValue());
        }
        if (other.hasKey()) {
          setKey(other.getKey());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasType()) {
          
          return false;
        }
        if (!hasValue()) {
          
          return false;
        }
        if (!hasKey()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              protos.HashTabOperationProtos.HashTabOperation.OperationType value = protos.HashTabOperationProtos.HashTabOperation.OperationType.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                type_ = value;
              }
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              value_ = input.readInt32();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              key_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required .HashTabOperation.OperationType type = 1;
      private protos.HashTabOperationProtos.HashTabOperation.OperationType type_ = protos.HashTabOperationProtos.HashTabOperation.OperationType.CONTAINS;
      public boolean hasType() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public protos.HashTabOperationProtos.HashTabOperation.OperationType getType() {
        return type_;
      }
      public Builder setType(protos.HashTabOperationProtos.HashTabOperation.OperationType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        type_ = value;
        onChanged();
        return this;
      }
      public Builder clearType() {
        bitField0_ = (bitField0_ & ~0x00000001);
        type_ = protos.HashTabOperationProtos.HashTabOperation.OperationType.CONTAINS;
        onChanged();
        return this;
      }
      
      // required int32 value = 2;
      private int value_ ;
      public boolean hasValue() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public int getValue() {
        return value_;
      }
      public Builder setValue(int value) {
        bitField0_ |= 0x00000002;
        value_ = value;
        onChanged();
        return this;
      }
      public Builder clearValue() {
        bitField0_ = (bitField0_ & ~0x00000002);
        value_ = 0;
        onChanged();
        return this;
      }
      
      // required string key = 3;
      private java.lang.Object key_ = "";
      public boolean hasKey() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public String getKey() {
        java.lang.Object ref = key_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          key_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setKey(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        key_ = value;
        onChanged();
        return this;
      }
      public Builder clearKey() {
        bitField0_ = (bitField0_ & ~0x00000004);
        key_ = getDefaultInstance().getKey();
        onChanged();
        return this;
      }
      void setKey(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000004;
        key_ = value;
        onChanged();
      }
      
      // @@protoc_insertion_point(builder_scope:HashTabOperation)
    }
    
    static {
      defaultInstance = new HashTabOperation(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:HashTabOperation)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_HashTabOperation_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_HashTabOperation_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026HashTabOperation.proto\"\252\001\n\020HashTabOper" +
      "ation\022-\n\004type\030\001 \002(\0162\037.HashTabOperation.O" +
      "perationType\022\r\n\005value\030\002 \002(\005\022\013\n\003key\030\003 \002(\t" +
      "\"K\n\rOperationType\022\014\n\010CONTAINS\020\000\022\007\n\003GET\020\001" +
      "\022\007\n\003PUT\020\002\022\007\n\003RMV\020\003\022\007\n\003ACK\020\004\022\010\n\004NACK\020\005B \n" +
      "\006protosB\026HashTabOperationProtos"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_HashTabOperation_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_HashTabOperation_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_HashTabOperation_descriptor,
              new java.lang.String[] { "Type", "Value", "Key", },
              protos.HashTabOperationProtos.HashTabOperation.class,
              protos.HashTabOperationProtos.HashTabOperation.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
